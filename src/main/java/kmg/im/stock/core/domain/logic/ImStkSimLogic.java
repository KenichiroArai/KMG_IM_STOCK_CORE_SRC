package kmg.im.stock.core.domain.logic;

import kmg.im.stock.core.domain.model.ImStkStockBrandModel;
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

}
