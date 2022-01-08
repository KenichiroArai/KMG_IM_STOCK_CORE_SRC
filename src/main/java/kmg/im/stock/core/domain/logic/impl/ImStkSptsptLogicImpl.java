package kmg.im.stock.core.domain.logic.impl;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;
import kmg.im.stock.core.data.dao.ImStkSptsptDao;
import kmg.im.stock.core.domain.logic.ImStkSptsptLogic;
import kmg.im.stock.core.domain.model.ImStkSptsptModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列期間の種類ロジックインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkSptsptLogicImpl implements ImStkSptsptLogic {

    /** 株価時系列期間の種類ＤＡＯ */
    private final ImStkSptsptDao imStkSptsptDao;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkSptsptDao
     *                       株価時系列期間の種類ＤＡＯ
     */
    public ImStkSptsptLogicImpl(final ImStkSptsptDao imStkSptsptDao) {
        this.imStkSptsptDao = imStkSptsptDao;
    }

    /**
     * 株価銘柄ＩＤと投資株式期間の種類の種類に該当するデータを削除する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *                             株価銘柄ＩＤ
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @return 削除数
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public long deleteBySbIdAndImStkPeriodTypeTypes(final long sbId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes)
        throws ImStkDomainException {
        long result = 0;
        try {
            result = this.imStkSptsptDao.deleteBySbIdAndImStkPeriodTypeTypes(sbId, imStkPeriodTypeTypes);
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/11 例外処理
            final String errMsg = KmgString.EMPTY;
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }
        return result;
    }

    /**
     * 株価時系列期間の種類IDを返す<br>
     * <p>
     * 該当がない場合は、nullを返す。<br>
     * </p>
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
    public Long getSptsptId(final long stockBrandId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes,
        final LocalDate baseDate) throws ImStkDomainException {
        Long result = null;
        try {
            result = this.imStkSptsptDao.getId(stockBrandId, imStkPeriodTypeTypes, baseDate);
        } catch (@SuppressWarnings("unused") final EmptyResultDataAccessException e) {
            // 該当なし

            return result;
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/11 例外処理
            final String errMsg = KmgString.EMPTY;
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }
        return result;
    }

    /**
     * 登録する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                             株銘柄ＩＤ
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     * @return 登録件数
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public long register(final long stockBrandId, final ImStkPeriodTypeTypes imStkPeriodTypeTypes)
        throws ImStkDomainException {
        long result = 0;
        try {
            result = this.imStkSptsptDao.insertBySbIdAndPtt(stockBrandId, imStkPeriodTypeTypes);
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/09 例外処理
            final String errMsg = KmgString.EMPTY;
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }
        return result;
    }

    /**
     * 期間の種類ごとの株価時系列期間の種類のマップを返す<br>
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
        final Map<ImStkPeriodTypeTypes, ImStkSptsptModel> result = null;
        return result;
    }
}
