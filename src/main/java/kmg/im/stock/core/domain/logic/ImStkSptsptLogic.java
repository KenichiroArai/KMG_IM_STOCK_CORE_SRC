package kmg.im.stock.core.domain.logic;

import java.time.LocalDate;
import java.util.Map;

import kmg.im.stock.core.domain.model.SptsptModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列期間の種類ロジックインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSptsptLogic {

    /**
     * 株価時系列期間の種類IDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                        株銘柄ID
     * @param periodTypeTypes
     *                        投資株式期間の種類の種類
     * @param baseDate
     *                        基準日
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    Long getSptsptId(long stockBrandId, ImStkPeriodTypeTypes periodTypeTypes, final LocalDate baseDate)
        throws ImStkDomainException;

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
     * 登録する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                        株銘柄ＩＤ
     * @param periodTypeTypes
     *                        投資株式期間の種類の種類
     * @return 登録件数
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    long register(long stockBrandId, ImStkPeriodTypeTypes periodTypeTypes) throws ImStkDomainException;

    /**
     * 期間の種類ごとの株価時系列期間の種類のマップを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                        株銘柄ID
     * @param periodTypeTypes
     *                        投資株式期間の種類の種類
     * @param baseDate
     *                        基準日
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    Map<ImStkPeriodTypeTypes, SptsptModel> findSptsptModelMap(long stockBrandId, ImStkPeriodTypeTypes periodTypeTypes,
        final LocalDate baseDate) throws ImStkDomainException;
}
