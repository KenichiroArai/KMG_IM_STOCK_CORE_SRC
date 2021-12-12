package kmg.im.stock.core.domain.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kmg.core.infrastructure.utils.ListUtils;
import kmg.im.stock.core.domain.logic.SimLogic;
import kmg.im.stock.core.domain.model.PosModel;
import kmg.im.stock.core.domain.model.StockBrandModel;
import kmg.im.stock.core.domain.model.StockPriceCalcValueModel;
import kmg.im.stock.core.domain.model.StockPriceTimeSeriesModel;
import kmg.im.stock.core.domain.service.SimulationService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.resolver.ImStkLogMessageResolver;
import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;
import kmg.im.stock.core.infrastructure.types.ImStkStockPriceCalcValueTypeTypes;

/**
 * シミュレーションサービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class SimulationServiceImpl implements SimulationService {

    /** ポジションマップ */
    private final Map<Long, PosModel> posMap;

    /** 投資株式ログメッセージリゾルバ */
    private final ImStkLogMessageResolver imStkLogMessageResolver;

    /** シミュレーションロジック */
    private final SimLogic simLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkLogMessageResolver
     *                                投資株式ログメッセージリゾルバ
     * @param simLogic
     *                                シミュレーションロジック
     */
    public SimulationServiceImpl(final ImStkLogMessageResolver imStkLogMessageResolver, final SimLogic simLogic) {
        this.posMap = new HashMap<>();
        this.imStkLogMessageResolver = imStkLogMessageResolver;
        this.simLogic = simLogic;
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

        /* 株価時系列管理モデルを取得する */
        final StockBrandModel stockBrandModel = this.simLogic.getStockPriceTimeSeriesMgtModel(stockCode);
        if (stockBrandModel == null) {

            // TODO KenichiroArai 2021/08/04 エラー対応
            final String errMsg = this.imStkLogMessageResolver.getMessage(ImStkLogMessageTypes.NONE);
            throw new ImStkDomainException(errMsg, ImStkLogMessageTypes.NONE);
        }
        // TODO KenichiroArai 2021/09/07 株銘柄へのモデル変更対応の一時的エラー回避株銘柄
//        final List<StockPriceTimeSeriesModel> stockPriceTimeSeriesModelList = stockBrandModel.toAllDataList();
        final List<StockPriceTimeSeriesModel> stockPriceTimeSeriesModelList = new ArrayList<>();
        if (ListUtils.isEmpty(stockPriceTimeSeriesModelList)) {
            return;
        }

        /* シミュレーションを行う */
        StockPriceTimeSeriesModel preStockPriceTimeSeriesModel = stockPriceTimeSeriesModelList.get(0);
        StockPriceCalcValueModel preStockPriceCalcValueMcadhModel = preStockPriceTimeSeriesModel
            .getStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.MCADH);
        for (int i = 1; i < stockPriceTimeSeriesModelList.size(); i++) {

            final StockPriceTimeSeriesModel stockPriceTimeSeriesModel = stockPriceTimeSeriesModelList.get(i);
            final StockPriceCalcValueModel stockPriceCalcValueMcadhModel = stockPriceTimeSeriesModel
                .getStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.MCADH);

            try {
                /* 第一のスクリーン */
                // 直近の週足２本のＭＡＣＤヒストグラムが変化なしまたは下向きか
                if (preStockPriceCalcValueMcadhModel.get().compareTo(stockPriceCalcValueMcadhModel.get()) >= 0) {
                    // 変化なしまたは下向きである場合

                    // 第一のスクリーンを突破しない
                    continue;
                }

                /* 第二のスクリーン */
                final StockPriceCalcValueModel stockPriceCalcValuePi2emaModel = stockPriceTimeSeriesModel
                    .getStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.PI2EMA);
                // 勢力指数２ＥＭＡが中心線よりも上以上か
                if (stockPriceCalcValuePi2emaModel.get().compareTo(BigDecimal.ZERO) >= 0) {
                    // 上以上である場合

                    // 第二のスクリーンを突破しない
                    continue;
                }
                final StockPriceCalcValueModel stockPriceCalcValueLpil3pModel = stockPriceTimeSeriesModel
                    .getStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.LOWEST_PRICE_IN_LAST3_PERIODS);
                // 過去３日間の最安値より安値が安いか
                if (stockPriceCalcValueLpil3pModel.get().compareTo(stockPriceTimeSeriesModel.getLp()) < 0) {
                    // 安い場合

                    // 第二のスクリーンを突破しない
                    continue;
                }

                System.out.println(stockPriceTimeSeriesModel.getPeriodStartDate());

            } finally {
                preStockPriceTimeSeriesModel = stockPriceTimeSeriesModelList.get(i);
                preStockPriceCalcValueMcadhModel = preStockPriceTimeSeriesModel
                    .getStockPriceCalcValueModel(ImStkStockPriceCalcValueTypeTypes.MCADH);
            }
        }
    }

    /**
     * ポジションモデルを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return ポジションモデル
     */
    @SuppressWarnings("static-method")
    private PosModel getPosModel() {
        final PosModel result = new PosModel();
        return result;
    }

}
