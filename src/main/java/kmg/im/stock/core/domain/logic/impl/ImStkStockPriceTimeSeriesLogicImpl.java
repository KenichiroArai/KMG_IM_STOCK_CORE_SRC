package kmg.im.stock.core.domain.logic.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.utils.ListUtils;
import kmg.im.stock.core.data.dao.ImStkStockPriceTimeSeriesDao;
import kmg.im.stock.core.data.dto.ImStkStockPriceTimeSeriesDto;
import kmg.im.stock.core.data.dto.impl.ImStkStockPriceTimeSeriesDtoImpl;
import kmg.im.stock.core.domain.logic.ImStkStockPriceTimeSeriesLogic;
import kmg.im.stock.core.domain.model.ImStkSimpleSptsMgtModel;
import kmg.im.stock.core.domain.model.ImStkSimpleSptsModel;
import kmg.im.stock.core.domain.model.ImStkSptsRegDataModel;
import kmg.im.stock.core.domain.model.impl.ImStkSimpleSptsMgtModelImpl;
import kmg.im.stock.core.domain.model.impl.ImStkSimpleSptsModelImpl;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列ロジック<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkStockPriceTimeSeriesLogicImpl implements ImStkStockPriceTimeSeriesLogic {

    /** 投資株式株価時系列ＤＡＯ */
    private final ImStkStockPriceTimeSeriesDao stockPriceTimeSeriesDao;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceTimeSeriesDao
     *                                投資株式株価時系列ＤＡＯ
     */
    public ImStkStockPriceTimeSeriesLogicImpl(final ImStkStockPriceTimeSeriesDao stockPriceTimeSeriesDao) {
        this.stockPriceTimeSeriesDao = stockPriceTimeSeriesDao;
    }

    /**
     * 株価銘柄ＩＤと投資株式期間の種類の種類に該当するデータを削除する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                             株価銘柄ＩＤ
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @return 削除数
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public long deleteBySbIdAndImStkPeriodTypeTypes(final long sbId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes)
        throws ImStkDomainException {
        long result = 0;
        try {
            result = this.stockPriceTimeSeriesDao.deleteBySbIdAndImStkPeriodTypeTypes(sbId, imStkPeriodTypeTypes);
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/11 例外処理
            final String errMsg = "";
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }
        return result;
    }

    /**
     * 期間の種類で株価時系列登録データモデルのリストを登録する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkPeriodTypeTypes
     *                                  投資株式期間の種類の種類
     * @param imStkSptsRegDataModelList
     *                                  株価時系列登録データモデルのリスト
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public void register(final ImStkPeriodTypeTypes imStkPeriodTypeTypes,
        final List<ImStkSptsRegDataModel> imStkSptsRegDataModelList) throws ImStkDomainException {

        if (ListUtils.isEmpty(imStkSptsRegDataModelList)) {
            return;
        }

        for (final ImStkSptsRegDataModel imStkSptsRegDataModel : imStkSptsRegDataModelList) {

            // TODO KenichiroArai 2021/05/20 BeanUtils.copyPropertiesをユーティリティ化する
            final ImStkStockPriceTimeSeriesDto imStkStockPriceTimeSeriesDto = new ImStkStockPriceTimeSeriesDtoImpl();
            BeanUtils.copyProperties(imStkSptsRegDataModel, imStkStockPriceTimeSeriesDto);

            try {
                this.stockPriceTimeSeriesDao.insertByPttAndSptsDto(imStkPeriodTypeTypes, imStkStockPriceTimeSeriesDto);
            } catch (final KmgDomainException e) {
                // TODO KenichiroArai 2021/06/12 例外処理
                final String errMsg = "";
                final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
                final Object[] logMsgArg = {};
                throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
            }
        }
    }

    /**
     * 株銘柄ＩＤと投資株式期間の種類の種類を基にシンプルモデルを返す検索を行う<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                             株銘柄ＩＤ
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @return 投資株式シンプル株価時系列管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public ImStkSimpleSptsMgtModel findSimpleBySbIdAndPti(final long sbId,
        final ImStkPeriodTypeTypes imStkPeriodTypeTypes) throws ImStkDomainException {
        final ImStkSimpleSptsMgtModel result = new ImStkSimpleSptsMgtModelImpl();

        /* 株銘柄ＩＤと投資株式期間の種類の種類を基に株価時系列ＤＴＯのリストを取得する */
        List<ImStkStockPriceTimeSeriesDto> imStkStockPriceTimeSeriesDtoList = null;
        try {
            imStkStockPriceTimeSeriesDtoList = this.stockPriceTimeSeriesDao.findBySbIdAndPtt(sbId,
                imStkPeriodTypeTypes);
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/11/24 例外処理
            final String errMsg = "";
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }

        /* シンプル株価時系列モデルのリストに詰め替える */
        final List<ImStkSimpleSptsModel> simpleSptsModelList = imStkStockPriceTimeSeriesDtoList.stream().map(mapper -> {
            final ImStkSimpleSptsModel simpleSptsModel = new ImStkSimpleSptsModelImpl();
            BeanUtils.copyProperties(mapper, simpleSptsModel);
            return simpleSptsModel;
        }).collect(Collectors.toList());

        /* 詰め替えたデータを結果に追加する */
        result.addAllData(simpleSptsModelList);

        return result;
    }
}
