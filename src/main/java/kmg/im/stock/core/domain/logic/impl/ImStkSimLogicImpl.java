package kmg.im.stock.core.domain.logic.impl;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.utils.KmgListUtils;
import kmg.im.stock.core.data.dao.ImStkSimDao;
import kmg.im.stock.core.data.dto.ImStkSimDto;
import kmg.im.stock.core.domain.logic.ImStkSimLogic;
import kmg.im.stock.core.domain.model.ImStkStockBrandModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceCalcValueModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceTimeSeriesModel;
import kmg.im.stock.core.domain.model.impl.ImStkStockBrandModelImpl;
import kmg.im.stock.core.domain.model.impl.ImStkStockPriceCalcValueModelImpl;
import kmg.im.stock.core.domain.model.impl.ImStkStockPriceTimeSeriesModelImpl;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;
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
        List<ImStkSimDto> imStkSimDtoList = null;
        try {
            imStkSimDtoList = this.imStkSimDao.find(stockCode);
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/11 例外処理
            final String errMsg = "";
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }

        /* 株価銘柄を設定する */
        if (KmgListUtils.isNotEmpty(imStkSimDtoList)) {
            final ImStkSimDto imStkSimDto = imStkSimDtoList.get(0);

            result.setStockBrandId(imStkSimDto.getStockBrandId()); // 株銘柄ID
            result.setStockBrandCode(imStkSimDto.getStockBrandCode()); // 株価銘柄コード
        }

        /* 株価時系列情報を設定する */
        final SortedMap<Long, ImStkStockPriceTimeSeriesModel> sptsMap = new TreeMap<>(); // 株価時系列モデルのマップ
        for (final ImStkSimDto imStkSimDto : imStkSimDtoList) {

            // 株価時系列モデルの取得
            ImStkStockPriceTimeSeriesModel sptsModel = sptsMap.get(imStkSimDto.getNo());
            if (sptsModel == null) {
                // 空の場合

                // 株価時系列情報を設定する
                sptsModel = new ImStkStockPriceTimeSeriesModelImpl();
                sptsModel.setId(imStkSimDto.getSptsId()); // 株価時系列ID
                sptsModel.setName(imStkSimDto.getSptsName()); // 株価時系列名称
                sptsModel.setNo(imStkSimDto.getNo()); // 番号
                sptsModel.setPeriodStartDate(imStkSimDto.getPeriodStartDate()); // 期間開始日
                sptsModel.setPeriodEndDate(imStkSimDto.getPeriodEndDate()); // 期間終了日
                sptsModel.setOp(imStkSimDto.getOp()); // 始値
                sptsModel.setHp(imStkSimDto.getHp()); // 高値
                sptsModel.setLp(imStkSimDto.getLp()); // 安値
                sptsModel.setCp(imStkSimDto.getCp()); // 終値
                sptsModel.setVolume(imStkSimDto.getVolume()); // 出来高

                // 株価時系列モデルのマップに追加する
                sptsMap.put(imStkSimDto.getNo(), sptsModel);

                // 投資株式株銘柄モデルに追加する
                // TODO KenichiroArai 2021/09/07 株銘柄へのモデル変更対応の一時的エラー回避株銘柄
//                final PeriodTypeTypes periodTypeTypes = PeriodTypeTypes.getEnum(imStkSimDto.getPeriodTypeId());
//                result.addData(periodTypeTypes, sptsModel);
            }

            // 株価計算値を設定する
            // 投資株式株価計算値の種類の種類を取得する
            final ImStkStockPriceCalcValueTypeTypes imStkStockPriceCalcValueTypeTypes = ImStkStockPriceCalcValueTypeTypes
                .getEnum(imStkSimDto.getSpcvtId());
            // 株価計算値モデルを取得する
            ImStkStockPriceCalcValueModel spcvModel = sptsModel
                .getImStkStockPriceCalcValueModel(imStkStockPriceCalcValueTypeTypes);
            if (spcvModel == null) {
                // データがない場合

                // 新規に作成
                spcvModel = new ImStkStockPriceCalcValueModelImpl();
                sptsModel.addSpcvModel(imStkStockPriceCalcValueTypeTypes, spcvModel);
            }
            // 株価計算値モデルを設定する
            spcvModel.setSpcvtId(imStkStockPriceCalcValueTypeTypes); // 株価計算値の種類ID
            spcvModel.setName(imStkSimDto.getSpcvtName()); // 株価計算値の種類名称
            spcvModel.setCalcValue(imStkSimDto.getCalcValue()); // 計算値
        }

        return result;
    }

    /**
     * 第１のスクリーンに掛ける<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkStockPriceTimeSeriesModel
     *                                       株価時系列
     * @return true：スクリーンに引っかる、false：スクリーンに引っかからない
     */
    @Override
    public boolean hangOnFirstScreen(final ImStkStockPriceTimeSeriesModel imStkStockPriceTimeSeriesModel) {
        // TODO KenichiroArai 2021/08/24 未実装
        return false;
    }

    /**
     * 第２のスクリーンに掛ける<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkStockPriceTimeSeriesModel
     *                                       投資株式株価時系列モデル
     * @return true：スクリーンに引っかる、false：スクリーンに引っかからない
     */
    @Override
    public boolean hangOnSecondScreen(final ImStkStockPriceTimeSeriesModel imStkStockPriceTimeSeriesModel) {
        // TODO KenichiroArai 2021/08/24 未実装
        return false;
    }

    /**
     * 第３のスクリーンに掛ける<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkStockPriceTimeSeriesModel
     *                                       投資株式株価時系列モデル
     * @return true：スクリーンに引っかる、false：スクリーンに引っかからない
     */
    @Override
    public boolean hangOnThirdScreen(final ImStkStockPriceTimeSeriesModel imStkStockPriceTimeSeriesModel) {
        // TODO KenichiroArai 2021/08/24 未実装
        return false;
    }

}
