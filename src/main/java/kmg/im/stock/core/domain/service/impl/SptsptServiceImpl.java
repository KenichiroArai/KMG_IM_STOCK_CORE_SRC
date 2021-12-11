package kmg.im.stock.core.domain.service.impl;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.SptsptLogic;
import kmg.im.stock.core.domain.model.SptsptModel;
import kmg.im.stock.core.domain.service.SptsptService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.PeriodTypeTypes;

/**
 * 株価時系列期間の種類サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class SptsptServiceImpl implements SptsptService {

    /** 株価時系列期間の種類ロジック */
    private final SptsptLogic sptsptLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsptLogic
     *                    株価時系列期間の種類ロジック
     */
    public SptsptServiceImpl(final SptsptLogic sptsptLogic) {
        this.sptsptLogic = sptsptLogic;
    }

    /**
     * 株価時系列期間の種類IDを返す<br>
     * <p>
     * システム日付に該当する株価時系列期間の種類IDを返す。<br>
     * <
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
    @Override
    public long getSptsptId(final long stockBrandId, final PeriodTypeTypes periodTypeTypes)
        throws ImStkDomainException {

        final long result = this.getSptsptId(stockBrandId, periodTypeTypes, LocalDate.now());
        return result;
    }

    /**
     * 株価時系列期間の種類IDを返す<br>
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
    @Override
    public long getSptsptId(final long stockBrandId, final PeriodTypeTypes periodTypeTypes, final LocalDate baseDate)
        throws ImStkDomainException {

        long result = -1L;

        final Long tmp = this.sptsptLogic.getSptsptId(stockBrandId, periodTypeTypes, baseDate);
        if (tmp != null) {
            result = tmp;
            return result;
        }

        this.sptsptLogic.register(stockBrandId, periodTypeTypes);
        result = this.sptsptLogic.getSptsptId(stockBrandId, periodTypeTypes, baseDate);

        return result;
    }

    // TODO KenichiroArai 2021/10/26 不要なら削除する
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
    @Override
    public Map<PeriodTypeTypes, SptsptModel> findSptsptModelMap(final long stockBrandId,
        final PeriodTypeTypes periodTypeTypes, final LocalDate baseDate) throws ImStkDomainException {
        final Map<PeriodTypeTypes, SptsptModel> result = this.sptsptLogic.findSptsptModelMap(stockBrandId,
            periodTypeTypes, baseDate);
        return result;
    }

}