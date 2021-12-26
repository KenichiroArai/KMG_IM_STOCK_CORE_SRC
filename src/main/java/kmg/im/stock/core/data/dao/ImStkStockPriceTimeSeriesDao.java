package kmg.im.stock.core.data.dao;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kmg.core.domain.model.SqlPathModel;
import kmg.core.domain.model.impl.SqlPathModelImpl;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.core.infrastructure.type.KmgString;
import kmg.im.stock.core.data.dto.ImStkSimpleSptsSearchConditionDto;
import kmg.im.stock.core.data.dto.ImStkSptsDeleteCondDto;
import kmg.im.stock.core.data.dto.ImStkSptsptDto;
import kmg.im.stock.core.data.dto.ImStkStockPriceTimeSeriesDto;
import kmg.im.stock.core.data.dto.impl.ImStkSimpleSptsSearchConditionDtoImpl;
import kmg.im.stock.core.data.dto.impl.ImStkSptsDeleteCondDtoImpl;
import kmg.im.stock.core.data.dto.impl.ImStkSptsptDtoImpl;
import kmg.im.stock.core.data.dto.impl.ImStkStockPriceTimeSeriesDtoImpl;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列ＤＡＯ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Repository
@SuppressWarnings("nls")
public class ImStkStockPriceTimeSeriesDao {

    /** 私自身のクラス */
    private static final Class<?> MYSELF_CLASS = ImStkStockPriceTimeSeriesDao.class;

    /** 株価銘柄ＩＤと投資株式期間の種類の種類に該当するデータを削除するＳＱＬパス */
    private static final SqlPathModel DELETE_BY_SB_ID_AND_PERIOD_TYPE_TYPES_SQL_PATH = new SqlPathModelImpl(
        ImStkStockPriceTimeSeriesDao.MYSELF_CLASS, Paths.get("deleteBySbIdAndImStkPeriodTypeTypes.sql"));

    /** 株価時系列を削除するＳＱＬパス */
    private static final SqlPathModel DELETE_SQL_PATH = new SqlPathModelImpl(ImStkStockPriceTimeSeriesDao.MYSELF_CLASS,
        Paths.get("delete.sql"));

    /** 投資株式期間の種類の種類と投資株式株価時系列ＤＴＯを基に挿入するＳＱＬパス */
    private static final SqlPathModel INSERT_BY_PTT_AND_SPTS_DTO_SQL_PATH = new SqlPathModelImpl(
        ImStkStockPriceTimeSeriesDao.MYSELF_CLASS, Paths.get("insertByPttAndSptsDto.sql"));

    /** 株銘柄ＩＤと投資株式期間の種類の種類を基に投資株式株価時系列ＤＴＯのリストを返す検索するＳＱＬパス */
    private static final SqlPathModel FIND_BY_SB_ID_AND_PTT_SQL_PATH = new SqlPathModelImpl(
        ImStkStockPriceTimeSeriesDao.MYSELF_CLASS, Paths.get("findBySbIdAndPtt.sql"));

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
    public ImStkStockPriceTimeSeriesDao(final NamedParameterJdbcTemplate jdbc) {
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
        final ImStkSptsDeleteCondDto imStkSptsDeleteCondDto = new ImStkSptsDeleteCondDtoImpl();
        imStkSptsDeleteCondDto.setStockBrandId(sbId);
        imStkSptsDeleteCondDto.setPeriodTypeId(periodTypeTypes.get());
        final SqlParameterSource param = new BeanPropertySqlParameterSource(imStkSptsDeleteCondDto);

        /* 削除する */
        result = this.jdbc.update(ImStkStockPriceTimeSeriesDao.DELETE_BY_SB_ID_AND_PERIOD_TYPE_TYPES_SQL_PATH.toSql(),
            param);

        return result;
    }

    /**
     * 削除する<br>
     * <p>
     * 期間の種類に該当するデータを削除する。
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param periodTypeTypes
     *                        投資株式期間の種類の種類
     * @return 削除数
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     */
    public long delete(final ImStkPeriodTypeTypes periodTypeTypes) throws KmgDomainException {

        long result = 0L;

        final ImStkSptsptDto imStkSptsptDto = new ImStkSptsptDtoImpl();
        imStkSptsptDto.setPeriodTypeId(periodTypeTypes.get());

        final SqlParameterSource param = new BeanPropertySqlParameterSource(imStkSptsptDto);
        result = this.jdbc.update(ImStkStockPriceTimeSeriesDao.DELETE_SQL_PATH.toSql(), param);

        return result;
    }

    /**
     * 投資株式期間の種類の種類と投資株式株価時系列ＤＴＯを基に挿入する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param ptt
     *                投資株式期間の種類の種類
     * @param sptsDto
     *                投資株式株価時系列ＤＴＯ
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     * @return 挿入数
     */
    public long insertByPttAndSptsDto(final ImStkPeriodTypeTypes ptt, final ImStkStockPriceTimeSeriesDto sptsDto)
        throws KmgDomainException {

        long result = 0L;

        /* パラメータを設定する */
        sptsDto.setStartDate(LocalDate.MIN);
        sptsDto.setEndDate(LocalDate.MAX);
        sptsDto.setLocaleId("ja"); // TODO KenichiroArai 2021/05/01 列挙型
        sptsDto.setCreator("TSSTS_MAIN_USER"); // TODO KenichiroArai 2021/05/01 後で考える
        sptsDto.setCreatedDate(LocalDateTime.now());
        sptsDto.setUpdater("TSSTS_MAIN_USER"); // TODO KenichiroArai 2021/05/01 後で考える
        sptsDto.setUpdateDate(LocalDateTime.now());
        sptsDto.setNote(KmgString.EMPTY);
        sptsDto.setName(KmgString.EMPTY);

        final SqlParameterSource param = new BeanPropertySqlParameterSource(sptsDto);
        result = this.jdbc.update(ImStkStockPriceTimeSeriesDao.INSERT_BY_PTT_AND_SPTS_DTO_SQL_PATH.toSql(), param);

        return result;

    }

    /**
     * 株銘柄ＩＤと投資株式期間の種類の種類を基に投資株式株価時系列ＤＴＯのリストを返す検索する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sbId
     *             株銘柄ＩＤ
     * @param ptt
     *             投資株式期間の種類の種類
     * @return 投資株式株価時系列ＤＴＯのリスト
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     */
    public List<ImStkStockPriceTimeSeriesDto> findBySbIdAndPtt(final long sbId, final ImStkPeriodTypeTypes ptt)
        throws KmgDomainException {

        List<ImStkStockPriceTimeSeriesDto> result = null;

        /* パラメータを設定する */
        final ImStkSimpleSptsSearchConditionDto imStkSimpleSptsSearchConditionDto = new ImStkSimpleSptsSearchConditionDtoImpl();
        imStkSimpleSptsSearchConditionDto.setStockBrandId(sbId);
        imStkSimpleSptsSearchConditionDto.setPeriodTypeId(ptt.get());

        /* DBを実行する */
        final SqlParameterSource params = new BeanPropertySqlParameterSource(imStkSimpleSptsSearchConditionDto);

        final List<ImStkStockPriceTimeSeriesDtoImpl> imStkStockPriceTimeSeriesDtoImplList = this.jdbc.query(
            ImStkStockPriceTimeSeriesDao.FIND_BY_SB_ID_AND_PTT_SQL_PATH.toSql(), params,
            BeanPropertyRowMapper.newInstance(ImStkStockPriceTimeSeriesDtoImpl.class));
        result = imStkStockPriceTimeSeriesDtoImplList.stream().collect(Collectors.toList());

        return result;

    }
}
