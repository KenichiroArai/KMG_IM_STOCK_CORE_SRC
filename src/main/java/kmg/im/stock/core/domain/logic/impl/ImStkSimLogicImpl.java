package kmg.im.stock.core.domain.logic.impl;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.utils.KmgListUtils;
import kmg.im.stock.core.data.dao.ImStkSimDao;
import kmg.im.stock.core.data.dto.ImStkSimDto;
import kmg.im.stock.core.domain.logic.ImStkSimLogic;
import kmg.im.stock.core.domain.model.ImStkSptsptModel;
import kmg.im.stock.core.domain.model.ImStkStockBrandModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceCalcValueModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceTimeSeriesModel;
import kmg.im.stock.core.domain.model.impl.ImStkSptsptModelImpl;
import kmg.im.stock.core.domain.model.impl.ImStkStockBrandModelImpl;
import kmg.im.stock.core.domain.model.impl.ImStkStockPriceCalcValueModelImpl;
import kmg.im.stock.core.domain.model.impl.ImStkStockPriceTimeSeriesModelImpl;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;
import kmg.im.stock.core.infrastructure.types.ImStkStockPriceCalcValueTypeTypes;

/**
 * 投資株式シミュレーションロジック<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkSimLogicImpl implements ImStkSimLogic {

    /** 投資株式シミュレーションＤＡＯ */
    private final ImStkSimDao imStkSimDao;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkSimDao
     *                    投資株式シミュレーションＤＡＯ
     */
    public ImStkSimLogicImpl(final ImStkSimDao imStkSimDao) {
        this.imStkSimDao = imStkSimDao;
    }

    /**
     * 株価コードに該当する投資株式株銘柄モデルを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockCode
     *                  株価コード
     * @return 投資株式株銘柄モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public ImStkStockBrandModel getImStkStockBrandModel(final long stockCode) throws ImStkDomainException {
        final ImStkStockBrandModel result = new ImStkStockBrandModelImpl();

        /* シミュレーションを行うデータを取得する */
        List<ImStkSimDto> acqSimDtoList = null;
        try {
            acqSimDtoList = this.imStkSimDao.find(stockCode);
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/11 例外処理
            final String errMsg = KmgString.EMPTY;
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }
        if (KmgListUtils.isEmpty(acqSimDtoList)) {

            // TODO KenichiroArai 2022/01/02 例外処理
            final String errMsg = String.format("シミュレーションを行うデータの取得に失敗しました。株価コード=[%s]", stockCode);
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg);
        }

        /* 株価銘柄を設定する */
        final ImStkSimDto headAcqSimDto = acqSimDtoList.get(0); // 先頭の取得シミュレーションＤＴＯ
        result.setStockBrandId(headAcqSimDto.getStockBrandId()); // 株銘柄ID
        result.setStockBrandCode(headAcqSimDto.getStockBrandCode()); // 株価銘柄コード

        /* 追加用の投資株式株価時系列モデルのマップを作成する */
        final SortedMap<ImStkPeriodTypeTypes, ImStkSptsptModel> addSptsptMap = new TreeMap<>();
        for (final ImStkSimDto acqSimDto : acqSimDtoList) {

            /* 投資株式期間の種類の種類を取得する */
            final ImStkPeriodTypeTypes acqPtTypes = ImStkPeriodTypeTypes.getEnum(acqSimDto.getPeriodTypeId());
            if (acqPtTypes == null) {

                // TODO KenichiroArai 2022/01/02 例外処理
                final String errMsg = String.format(
                    "シミュレーションを行うデータの投資株式期間の種類の種類の取得に失敗しました。株銘柄ID=[%ld], 株価コード=[%s], 株銘柄名称=[%s], 期間の種類ID=[%ld], 期間の種類名称=[%s], 株価時系列ID=[%ld], 株価時系列名称=[%s], 番号=[%ld]",
                    acqSimDto.getStockBrandId(), stockCode, acqSimDto.getStockBrandName(), acqSimDto.getPeriodTypeId(),
                    acqSimDto.getPeriodTypeName(), acqSimDto.getSptsId(), acqSimDto.getSptsName(), acqSimDto.getNo());
                final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
                final Object[] logMsgArg = {};
                throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg);
            }

            /* 追加用の投資株式株価時系列期間の種類モデルを取得する */
            ImStkSptsptModel addSptsptModel = addSptsptMap.get(acqPtTypes);
            if (addSptsptModel == null) {
                // データがない場合

                // 新規に作成する
                addSptsptModel = new ImStkSptsptModelImpl(acqPtTypes);
                addSptsptMap.put(acqPtTypes, addSptsptModel);
            }

            /* 追加用の投資株式株価時系列モデルを作成する */
            ImStkStockPriceTimeSeriesModel addSptsModel = addSptsptModel.getSptsModel(acqSimDto.getNo()); // 追加用の投資株式株価時系列モデル
            if (addSptsModel == null) {
                addSptsModel = new ImStkStockPriceTimeSeriesModelImpl();
                addSptsModel.setId(acqSimDto.getSptsId()); // 株価時系列ID
                addSptsModel.setName(acqSimDto.getSptsName()); // 株価時系列名称
                addSptsModel.setNo(acqSimDto.getNo()); // 番号
                addSptsModel.setPeriodStartDate(acqSimDto.getPeriodStartDate()); // 期間開始日
                addSptsModel.setPeriodEndDate(acqSimDto.getPeriodEndDate()); // 期間終了日
                addSptsModel.setOp(acqSimDto.getOp()); // 始値
                addSptsModel.setHp(acqSimDto.getHp()); // 高値
                addSptsModel.setLp(acqSimDto.getLp()); // 安値
                addSptsModel.setCp(acqSimDto.getCp()); // 終値
                addSptsModel.setVolume(acqSimDto.getVolume()); // 出来高
                addSptsptModel.addSptsModel(addSptsModel);
            }

            /* 株価計算値を設定する */
            // 投資株式株価計算値の種類の種類を取得する
            final ImStkStockPriceCalcValueTypeTypes acqSpcvtTypes = ImStkStockPriceCalcValueTypeTypes
                .getEnum(acqSimDto.getSpcvtId());
            if (acqSpcvtTypes == null) {

                // TODO KenichiroArai 2022/01/02 例外処理
                final String errMsg = String.format(
                    "シミュレーションを行うデータの投資株式株価計算値の種類の種類の取得に失敗しました。株銘柄ID=[%ld], 株価コード=[%s], 株銘柄名称=[%s], 期間の種類ID=[%ld], 期間の種類名称=[%s], 株価時系列ID=[%ld], 株価時系列名称=[%s], 番号=[%ld]",
                    acqSimDto.getStockBrandId(), stockCode, acqSimDto.getStockBrandName(), acqSimDto.getPeriodTypeId(),
                    acqSimDto.getPeriodTypeName(), acqSimDto.getSptsId(), acqSimDto.getSptsName(), acqSimDto.getNo());
                final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
                final Object[] logMsgArg = {};
                throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg);
            }
            // 追加用の株価計算値モデルを作成する
            final ImStkStockPriceCalcValueModel addSpcvModel = new ImStkStockPriceCalcValueModelImpl();
            // 株価計算値モデルを設定する
            addSpcvModel.setSpcvtId(acqSpcvtTypes); // 株価計算値の種類ID
            addSpcvModel.setName(acqSimDto.getSpcvtName()); // 株価計算値の種類名称
            addSpcvModel.setCalcValue(acqSimDto.getCalcValue()); // 計算値
            addSptsModel.addSpcvModel(acqSpcvtTypes, addSpcvModel);

        }
        result.addImStkSptsptMap(addSptsptMap);

        return result;
    }

}
