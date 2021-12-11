package kmg.im.stock.core.domain.logic;

import kmg.im.stock.core.domain.model.StockBrandModel;
import kmg.im.stock.core.domain.model.StockPriceTimeSeriesModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;

/**
 * シミュレーションロジックのインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface SimLogic {

    /**
     * 株価コードに該当する株価時系列管理モデルを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockCode
     *                  株価コード
     * @return 株価時系列管理
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    StockBrandModel getStockPriceTimeSeriesMgtModel(long stockCode) throws ImStkDomainException;

    /**
     * 第１のスクリーンに掛ける<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceTimeSeries
     *                             株価時系列
     * @return true：スクリーンに引っかる、false：スクリーンに引っかからない
     */
    boolean hangOnFirstScreen(StockPriceTimeSeriesModel stockPriceTimeSeries);

    /**
     * 第２のスクリーンに掛ける<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceTimeSeries
     *                             株価時系列
     * @return true：スクリーンに引っかる、false：スクリーンに引っかからない
     */
    boolean hangOnSecondScreen(StockPriceTimeSeriesModel stockPriceTimeSeries);

    /**
     * 第３のスクリーンに掛ける<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceTimeSeries
     *                             株価時系列
     * @return true：スクリーンに引っかる、false：スクリーンに引っかからない
     */
    boolean hangOnThirdScreen(StockPriceTimeSeriesModel stockPriceTimeSeries);

}
