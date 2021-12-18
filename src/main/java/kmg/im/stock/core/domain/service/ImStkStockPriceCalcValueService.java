package kmg.im.stock.core.domain.service;

import kmg.im.stock.core.domain.model.StockPriceCalcValueMgtModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;

/**
 * 投資株式株価計算値サービスインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkStockPriceCalcValueService {

    /**
     * 登録する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceCalcValueMgtModel
     *                                    株価計算値管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    void register(StockPriceCalcValueMgtModel stockPriceCalcValueMgtModel) throws ImStkDomainException;
}
