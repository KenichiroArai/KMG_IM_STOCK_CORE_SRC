package kmg.im.stock.core.domain.service.impl;

import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.StockPriceTimeSeriesLogic;
import kmg.im.stock.core.domain.model.SimpleSptsMgtModel;
import kmg.im.stock.core.domain.service.StockPriceTimeSeriesService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.PeriodTypeTypes;

/**
 * 株価時系列サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class StockPriceTimeSeriesServiceImpl implements StockPriceTimeSeriesService {

    /** 株価時系列ロジック */
    private final StockPriceTimeSeriesLogic stockPriceTimeSeriesLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceTimeSeriesLogic
     *                                  株価時系列ロジック
     */
    public StockPriceTimeSeriesServiceImpl(final StockPriceTimeSeriesLogic stockPriceTimeSeriesLogic) {
        this.stockPriceTimeSeriesLogic = stockPriceTimeSeriesLogic;
    }

    /**
     * 株銘柄ＩＤと期間の種類の種類を基にシンプルモデルを返す検索を行う<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                        株銘柄ＩＤ
     * @param periodTypeTypes
     *                        期間の種類の種類
     * @return シンプル株価時系列管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public SimpleSptsMgtModel findSimpleBySbIdAndPti(final long sbId, final PeriodTypeTypes periodTypeTypes)
        throws ImStkDomainException {
        final SimpleSptsMgtModel result = this.stockPriceTimeSeriesLogic.findSimpleBySbIdAndPti(sbId, periodTypeTypes);
        return result;
    }

}
