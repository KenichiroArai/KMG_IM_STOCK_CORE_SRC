package kmg.im.stock.core.domain.service;

import kmg.im.stock.core.domain.model.ImStkSimpleSptsMgtModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列サービスインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkStockPriceTimeSeriesService {

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
     * @return 投資株式シンプル株価時系列モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    ImStkSimpleSptsMgtModel findSimpleBySbIdAndPti(final long sbId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes)
        throws ImStkDomainException;

}
