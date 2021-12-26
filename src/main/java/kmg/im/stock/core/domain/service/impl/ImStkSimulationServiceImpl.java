package kmg.im.stock.core.domain.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kmg.core.infrastructure.utils.ListUtils;
import kmg.im.stock.core.domain.logic.ImStkSimLogic;
import kmg.im.stock.core.domain.model.ImStkPosModel;
import kmg.im.stock.core.domain.model.ImStkStockBrandModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceCalcValueModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceTimeSeriesModel;
import kmg.im.stock.core.domain.service.ImStkSimulationService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.resolver.ImStkLogMessageResolver;
import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;
import kmg.im.stock.core.infrastructure.types.ImStkStockPriceCalcValueTypeTypes;

/**
 * 投資株式シミュレーションサービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkSimulationServiceImpl implements ImStkSimulationService {

    /** ポジションマップ */
    private final Map<Long, ImStkPosModel> posMap;

    /** 投資株式ログメッセージリゾルバ */
    private final ImStkLogMessageResolver imStkLogMessageResolver;

    /** 投資株式シミュレーションロジック */
    private final ImStkSimLogic imStkSimLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkLogMessageResolver
     *                                投資株式ログメッセージリゾルバ
     * @param imStkSimLogic
     *                                投資株式シミュレーションロジック
     */
    public ImStkSimulationServiceImpl(final ImStkLogMessageResolver imStkLogMessageResolver,
        final ImStkSimLogic imStkSimLogic) {
        this.posMap = new HashMap<>();
        this.imStkLogMessageResolver = imStkLogMessageResolver;
        this.imStkSimLogic = imStkSimLogic;
    }

    /**
     * 全ての銘柄をシミュレーションする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public void simulate() throws ImStkDomainException {
        // TODO KenichiroArai 2021/08/04 実装中
        this.simulate(3053);
    }

    /**
     * シミュレーションする<br>
     * <p>
     * 指定した株コードのシミュレーションする
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockCode
     *                  株コード
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public void simulate(final long stockCode) throws ImStkDomainException {
        // TODO KenichiroArai 2021/05/25 実装中

        /* 投資株式株銘柄モデルを取得する */
        final ImStkStockBrandModel imStkStockBrandModel = this.imStkSimLogic.getImStkStockBrandModel(stockCode);
        if (imStkStockBrandModel == null) {

            // TODO KenichiroArai 2021/08/04 エラー対応
            final String errMsg = this.imStkLogMessageResolver.getMessage(ImStkLogMessageTypes.NONE);
            throw new ImStkDomainException(errMsg, ImStkLogMessageTypes.NONE);
        }
        // TODO KenichiroArai 2021/09/07 株銘柄へのモデル変更対応の一時的エラー回避株銘柄
//        final List<ImStkStockPriceTimeSeriesModel> imStkStockPriceTimeSeriesModelList = imStkStockBrandModel.toAllDataList();
        final List<ImStkStockPriceTimeSeriesModel> imStkStockPriceTimeSeriesModelList = new ArrayList<>();
        if (ListUtils.isEmpty(imStkStockPriceTimeSeriesModelList)) {
            return;
        }

        /* シミュレーションを行う */
        ImStkStockPriceTimeSeriesModel preImStkStockPriceTimeSeriesModel = imStkStockPriceTimeSeriesModelList.get(0);
        ImStkStockPriceCalcValueModel preImStkStockPriceCalcValueMcadhModel = preImStkStockPriceTimeSeriesModel
            .getImStkStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.MCADH);
        for (int i = 1; i < imStkStockPriceTimeSeriesModelList.size(); i++) {

            final ImStkStockPriceTimeSeriesModel imStkStockPriceTimeSeriesModel = imStkStockPriceTimeSeriesModelList
                .get(i);
            final ImStkStockPriceCalcValueModel stockPriceCalcValueMcadhModel = imStkStockPriceTimeSeriesModel
                .getImStkStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.MCADH);

            try {
                /* 第一のスクリーン */
                // 直近の週足２本のＭＡＣＤヒストグラムが変化なしまたは下向きか
                if (preImStkStockPriceCalcValueMcadhModel.get().compareTo(stockPriceCalcValueMcadhModel.get()) >= 0) {
                    // 変化なしまたは下向きである場合

                    // 第一のスクリーンを突破しない
                    continue;
                }

                /* 第二のスクリーン */
                final ImStkStockPriceCalcValueModel stockPriceCalcValuePi2emaModel = imStkStockPriceTimeSeriesModel
                    .getImStkStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.PI2EMA);
                // 勢力指数２ＥＭＡが中心線よりも上以上か
                if (stockPriceCalcValuePi2emaModel.get().compareTo(BigDecimal.ZERO) >= 0) {
                    // 上以上である場合

                    // 第二のスクリーンを突破しない
                    continue;
                }
                final ImStkStockPriceCalcValueModel stockPriceCalcValueLpil3pModel = imStkStockPriceTimeSeriesModel
                    .getImStkStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.LOWEST_PRICE_IN_LAST3_PERIODS);
                // 過去３日間の最安値より安値が安いか
                if (stockPriceCalcValueLpil3pModel.get().compareTo(imStkStockPriceTimeSeriesModel.getLp()) < 0) {
                    // 安い場合

                    // 第二のスクリーンを突破しない
                    continue;
                }

                System.out.println(imStkStockPriceTimeSeriesModel.getPeriodStartDate());

            } finally {
                preImStkStockPriceTimeSeriesModel = imStkStockPriceTimeSeriesModelList.get(i);
                preImStkStockPriceCalcValueMcadhModel = preImStkStockPriceTimeSeriesModel
                    .getImStkStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.MCADH);
            }
        }
    }

    /**
     * 投資株式ポジションモデルを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式ポジションモデル
     */
    @SuppressWarnings("static-method")
    private ImStkPosModel getImStkPosModel() {
        final ImStkPosModel result = new ImStkPosModel();
        return result;
    }

}
