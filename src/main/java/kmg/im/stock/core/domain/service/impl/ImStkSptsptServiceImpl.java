package kmg.im.stock.core.domain.service.impl;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.ImStkSptsptLogic;
import kmg.im.stock.core.domain.model.ImStkSptsptModel;
import kmg.im.stock.core.domain.service.ImStkSptsptService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列期間の種類サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkSptsptServiceImpl implements ImStkSptsptService {

    /** 投資株式株価時系列期間の種類ロジック */
    private final ImStkSptsptLogic imStkSptsptLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkSptsptLogic
     *                         投資株式株価時系列期間の種類ロジック
     */
    public ImStkSptsptServiceImpl(final ImStkSptsptLogic imStkSptsptLogic) {
        this.imStkSptsptLogic = imStkSptsptLogic;
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
     *                             株銘柄ID
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public long getSptsptId(final long stockBrandId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes)
        throws ImStkDomainException {

        final long result = this.getSptsptId(stockBrandId, imStkPeriodTypeTypes, LocalDate.now());
        return result;
    }

    /**
     * 株価時系列期間の種類IDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                             株銘柄ID
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @param baseDate
     *                             基準日
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public long getSptsptId(final long stockBrandId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes,
        final LocalDate baseDate) throws ImStkDomainException {

        long result = -1L;

        final Long tmp = this.imStkSptsptLogic.getSptsptId(stockBrandId, imStkPeriodTypeTypes, baseDate);
        if (tmp != null) {
            result = tmp;
            return result;
        }

        this.imStkSptsptLogic.register(stockBrandId, imStkPeriodTypeTypes);
        result = this.imStkSptsptLogic.getSptsptId(stockBrandId, imStkPeriodTypeTypes, baseDate);

        return result;
    }

    // TODO KenichiroArai 2021/10/26 不要なら削除する
    /**
     * 期間の種類ごとの投資株式株価時系列期間の種類モデルのマップを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                             株銘柄ID
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @param baseDate
     *                             基準日
     * @return 株価銘柄ID
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public Map<ImStkPeriodTypeTypes, ImStkSptsptModel> findImStkSptsptModelMap(final long stockBrandId,
        final ImStkPeriodTypeTypes imStkPeriodTypeTypes, final LocalDate baseDate) throws ImStkDomainException {
        final Map<ImStkPeriodTypeTypes, ImStkSptsptModel> result = this.imStkSptsptLogic
            .findImStkSptsptModelMap(stockBrandId, imStkPeriodTypeTypes, baseDate);
        return result;
    }

}
