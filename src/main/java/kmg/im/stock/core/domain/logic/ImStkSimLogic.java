package kmg.im.stock.core.domain.logic;

import kmg.im.stock.core.domain.model.ImStkStockBrandModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceTimeSeriesModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;

/**
 * 投資株式シミュレーションロジックのインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSimLogic {

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
    ImStkStockBrandModel getImStkStockBrandModel(long stockCode) throws ImStkDomainException;

    /**
     * 第１のスクリーンに掛ける<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkStockPriceTimeSeriesModel
     *                                       投資株式株価時系列モデル
     * @return true：スクリーンに引っかる、false：スクリーンに引っかからない
     */
    boolean hangOnFirstScreen(ImStkStockPriceTimeSeriesModel imStkStockPriceTimeSeriesModel);

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
    boolean hangOnSecondScreen(ImStkStockPriceTimeSeriesModel imStkStockPriceTimeSeriesModel);

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
    boolean hangOnThirdScreen(ImStkStockPriceTimeSeriesModel imStkStockPriceTimeSeriesModel);

}
