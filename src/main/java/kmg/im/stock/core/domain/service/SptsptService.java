package kmg.im.stock.core.domain.service;

import java.time.LocalDate;
import java.util.Map;

import kmg.im.stock.core.domain.model.SptsptModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.PeriodTypeTypes;

/**
 * 株価時系列期間の種類サービスインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface SptsptService {

    /**
     * 株価時系列期間の種類の種類を返す<br>
     * <p>
     * システム日付に該当する。
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                        株銘柄ID
     * @param periodTypeTypes
     *                        期間の種類の種類
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    long getSptsptId(long stockBrandId, PeriodTypeTypes periodTypeTypes) throws ImStkDomainException;

    /**
     * 株価時系列期間の種類の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                        株銘柄ID
     * @param periodTypeTypes
     *                        期間の種類の種類
     * @param baseDate
     *                        基準日
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    long getSptsptId(long stockBrandId, PeriodTypeTypes periodTypeTypes, final LocalDate baseDate)
        throws ImStkDomainException;

    /**
     * 期間の種類ごとの株価時系列期間の種類のマップを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                        株銘柄ID
     * @param periodTypeTypes
     *                        期間の種類の種類
     * @param baseDate
     *                        基準日
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    Map<PeriodTypeTypes, SptsptModel> findSptsptModelMap(long stockBrandId, PeriodTypeTypes periodTypeTypes,
        final LocalDate baseDate) throws ImStkDomainException;
}
