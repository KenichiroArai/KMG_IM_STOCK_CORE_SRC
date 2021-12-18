package kmg.im.stock.core.domain.service.impl;

import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.ImStkStockPriceTimeSeriesLogic;
import kmg.im.stock.core.domain.model.SimpleSptsMgtModel;
import kmg.im.stock.core.domain.service.ImStkStockPriceTimeSeriesService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkStockPriceTimeSeriesServiceImpl implements ImStkStockPriceTimeSeriesService {

    /** 投資株式株価時系列ロジック */
    private final ImStkStockPriceTimeSeriesLogic stockPriceTimeSeriesLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceTimeSeriesLogic
     *                                  投資株式株価時系列ロジック
     */
    public ImStkStockPriceTimeSeriesServiceImpl(final ImStkStockPriceTimeSeriesLogic stockPriceTimeSeriesLogic) {
        this.stockPriceTimeSeriesLogic = stockPriceTimeSeriesLogic;
    }

    /**
     * 株銘柄ＩＤと投資株式期間の種類の種類を基にシンプルモデルを返す検索を行う<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                                  株銘柄ＩＤ
     * @param imStkImStkPeriodTypeTypes
     *                                  投資株式期間の種類の種類
     * @return シンプル株価時系列管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public SimpleSptsMgtModel findSimpleBySbIdAndPti(final long sbId,
        final ImStkPeriodTypeTypes imStkImStkPeriodTypeTypes) throws ImStkDomainException {
        final SimpleSptsMgtModel result = this.stockPriceTimeSeriesLogic.findSimpleBySbIdAndPti(sbId,
            imStkImStkPeriodTypeTypes);
        return result;
    }

}
