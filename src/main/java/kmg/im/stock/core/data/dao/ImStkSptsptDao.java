package kmg.im.stock.core.data.dao;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kmg.core.domain.model.KmgSqlPathModel;
import kmg.core.domain.model.impl.KmgSqlPathModelImpl;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;
import kmg.im.stock.core.data.dto.ImStkSptsptDeleteCondDto;
import kmg.im.stock.core.data.dto.ImStkSptsptDto;
import kmg.im.stock.core.data.dto.ImStkSptsptRegDto;
import kmg.im.stock.core.data.dto.impl.ImStkSptsptDeleteCondDtoImpl;
import kmg.im.stock.core.data.dto.impl.ImStkSptsptDtoImpl;
import kmg.im.stock.core.data.dto.impl.ImStkSptsptRegDtoImpl;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列期間の種類ＤＡＯ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Repository
@SuppressWarnings("nls")
public class ImStkSptsptDao {

    /** 私自身のクラス */
    private static final Class<?> MYSELF_CLASS = ImStkSptsptDao.class;

    /** 株価銘柄ＩＤと投資株式期間の種類の種類に該当するデータを削除するＳＱＬパス */
    private static final KmgSqlPathModel DELETE_BY_SB_ID_AND_PERIOD_TYPE_TYPES_SQL_PATH = new KmgSqlPathModelImpl(
        ImStkSptsptDao.MYSELF_CLASS, Paths.get("deleteBySbIdAndImStkPeriodTypeTypes.sql"));

    /** 識別番号を取得するＳＱＬパス */
    private static final KmgSqlPathModel GET_ID_SQL_PATH = new KmgSqlPathModelImpl(ImStkSptsptDao.MYSELF_CLASS,
        Paths.get("getId.sql"));

    /** 株銘柄ＩＤと投資株式期間の種類の種類を基に挿入するＳＱＬパス */
    private static final KmgSqlPathModel INSERT_BY_SB_ID_AND_PTT_SQL_PATH = new KmgSqlPathModelImpl(
        ImStkSptsptDao.MYSELF_CLASS, Paths.get("insertBySbIdAndPtt.sql"));

    /** データベース接続 */
    private final NamedParameterJdbcTemplate jdbc;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param jdbc
     *             データベース接続
     */
    public ImStkSptsptDao(final NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

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
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     */
    public long deleteBySbIdAndImStkPeriodTypeTypes(final long sbId, final ImStkPeriodTypeTypes periodTypeTypes)
        throws KmgDomainException {

        long result = 0L;

        /* パラメータを設定する */
        final ImStkSptsptDeleteCondDto imStkSptsptDeleteCondDto = new ImStkSptsptDeleteCondDtoImpl();
        imStkSptsptDeleteCondDto.setStockBrandId(sbId);
        imStkSptsptDeleteCondDto.setPeriodTypeId(periodTypeTypes.get());
        final SqlParameterSource param = new BeanPropertySqlParameterSource(imStkSptsptDeleteCondDto);

        /* 削除する */
        result = this.jdbc.update(ImStkSptsptDao.DELETE_BY_SB_ID_AND_PERIOD_TYPE_TYPES_SQL_PATH.toSql(), param);

        return result;
    }

    /**
     * 識別番号を取得する<br>
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
     * @return 識別番号
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     */
    public long getId(final long stockBrandId, final ImStkPeriodTypeTypes periodTypeTypes, final LocalDate baseDate)
        throws KmgDomainException {

        long result = 0L;

        /* パラメータを設定する */
        final ImStkSptsptDto imStkSptsptDto = new ImStkSptsptDtoImpl();
        imStkSptsptDto.setStockBrandId(stockBrandId);
        imStkSptsptDto.setPeriodTypeId(periodTypeTypes.get());
        imStkSptsptDto.setStartDate(baseDate);

        /* DBを実行する */
        final SqlParameterSource params = new BeanPropertySqlParameterSource(imStkSptsptDto);
        result = this.jdbc.queryForObject(ImStkSptsptDao.GET_ID_SQL_PATH.toSql(), params, Long.class);

        return result;

    }

    /**
     * 株銘柄ＩＤと投資株式期間の種類の種類を基に挿入する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *             株銘柄ＩＤ
     * @param ptt
     *             投資株式期間の種類の種類
     * @return 登録件数
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     */
    public long insertBySbIdAndPtt(final long sbId, final ImStkPeriodTypeTypes ptt) throws KmgDomainException {

        long result = 0L;

        /* パラメータを設定する */
        final ImStkSptsptRegDto imStkSptsptRegDto = new ImStkSptsptRegDtoImpl();
        imStkSptsptRegDto.setStartDate(LocalDate.MIN);
        imStkSptsptRegDto.setEndDate(LocalDate.MAX);
        imStkSptsptRegDto.setLocaleId("ja"); // TODO KenichiroArai 2021/06/05 列挙型
        imStkSptsptRegDto.setCreator("TSSTS_MAIN_USER"); // TODO KenichiroArai 2021/06/05 後で考える
        imStkSptsptRegDto.setCreatedDate(LocalDateTime.now());
        imStkSptsptRegDto.setUpdater("TSSTS_MAIN_USER"); // TODO KenichiroArai 2021/06/05 後で考える
        imStkSptsptRegDto.setUpdateDate(LocalDateTime.now());
        imStkSptsptRegDto.setNote(KmgString.EMPTY);
        imStkSptsptRegDto.setStockBrandId(sbId);
        imStkSptsptRegDto.setPeriodTypeId(ptt.get());

        /* DBを実行する */
        final SqlParameterSource params = new BeanPropertySqlParameterSource(imStkSptsptRegDto);
        result = this.jdbc.update(ImStkSptsptDao.INSERT_BY_SB_ID_AND_PTT_SQL_PATH.toSql(), params);

        return result;
    }

}
