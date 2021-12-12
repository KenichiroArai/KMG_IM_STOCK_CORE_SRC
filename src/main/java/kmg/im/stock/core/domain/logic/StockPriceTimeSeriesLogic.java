package kmg.im.stock.core.domain.logic;

import java.util.List;

import kmg.im.stock.core.domain.model.SimpleSptsMgtModel;
import kmg.im.stock.core.domain.model.SptsRegDataModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 株価時系列ロジックインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface StockPriceTimeSeriesLogic {

    /**
     * 株価銘柄ＩＤと投資株式期間の種類の種類に該当するデータを削除する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                        株価銘柄ＩＤ
     * @param periodTypeTypes
     *                        投資株式期間の種類の種類
     * @return 削除数
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    long deleteBySbIdAndImStkPeriodTypeTypes(final long sbId, final ImStkPeriodTypeTypes periodTypeTypes)
        throws ImStkDomainException;

    /**
     * 期間の種類で株価時系列登録データモデルのリストを登録する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param periodTypeTypes
     *                              投資株式期間の種類の種類
     * @param sptsMainDataModelList
     *                              株価時系列登録データモデルのリスト
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    void register(ImStkPeriodTypeTypes periodTypeTypes, final List<SptsRegDataModel> sptsMainDataModelList)
        throws ImStkDomainException;

    /**
     * 株銘柄ＩＤと投資株式期間の種類の種類を基にシンプルモデルを返す検索を行う<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                        株銘柄ＩＤ
     * @param periodTypeTypes
     *                        投資株式期間の種類の種類
     * @return シンプル株価時系列管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    SimpleSptsMgtModel findSimpleBySbIdAndPti(final long sbId, final ImStkPeriodTypeTypes periodTypeTypes)
        throws ImStkDomainException;
}
