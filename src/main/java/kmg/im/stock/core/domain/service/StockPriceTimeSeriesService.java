package kmg.im.stock.core.domain.service;

import kmg.im.stock.core.domain.model.SimpleSptsMgtModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 株価時系列サービスインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface StockPriceTimeSeriesService {

    /**
     * 株銘柄ＩＤと投資株式期間の種類の種類を基にシンプルモデルを返す検索を行う<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                             株銘柄ＩＤ
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @return シンプル株価時系列管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    SimpleSptsMgtModel findSimpleBySbIdAndPti(final long sbId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes)
        throws ImStkDomainException;

}
