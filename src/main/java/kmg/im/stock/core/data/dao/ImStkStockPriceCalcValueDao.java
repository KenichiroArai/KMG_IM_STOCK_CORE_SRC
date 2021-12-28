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
import kmg.im.stock.core.data.dto.ImStkSpcvDeleteCondDto;
import kmg.im.stock.core.data.dto.ImStkStockPriceCalcValueDto;
import kmg.im.stock.core.data.dto.impl.ImStkSpcvDeleteCondDtoImpl;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価計算値ＤＡＯ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Repository
@SuppressWarnings("nls")
public class ImStkStockPriceCalcValueDao {

    /** 私自身のクラス */
    private static final Class<?> MYSELF_CLASS = ImStkStockPriceCalcValueDao.class;

    /** 株価銘柄ＩＤと投資株式期間の種類の種類に該当するデータを削除するＳＱＬパス */
    private static final KmgSqlPathModel DELETE_BY_SB_ID_AND_PERIOD_TYPE_TYPES_SQL_PATH = new KmgSqlPathModelImpl(
        ImStkStockPriceCalcValueDao.MYSELF_CLASS, Paths.get("deleteBySbIdAndImStkPeriodTypeTypes.sql"));

    /** 株価計算値を挿入するＳＱＬパス */
    private static final KmgSqlPathModel INSERT_SQL_PATH = new KmgSqlPathModelImpl(
        ImStkStockPriceCalcValueDao.MYSELF_CLASS, Paths.get("insert.sql"));

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
    public ImStkStockPriceCalcValueDao(final NamedParameterJdbcTemplate jdbc) {
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
    public long deleteByIdCdAndImStkPeriodTypeTypes(final long sbId, final ImStkPeriodTypeTypes periodTypeTypes)
        throws KmgDomainException {

        long result = 0L;

        /* パラメータを設定する */
        final ImStkSpcvDeleteCondDto imStkSpcvDeleteCondDto = new ImStkSpcvDeleteCondDtoImpl();
        imStkSpcvDeleteCondDto.setStockBrandId(sbId);
        imStkSpcvDeleteCondDto.setPeriodTypeId(periodTypeTypes.get());
        final SqlParameterSource param = new BeanPropertySqlParameterSource(imStkSpcvDeleteCondDto);

        /* SQLを作成する */
        final String sql = ImStkStockPriceCalcValueDao.DELETE_BY_SB_ID_AND_PERIOD_TYPE_TYPES_SQL_PATH.toSql();

        /* 削除する */
        result = this.jdbc.update(sql, param);

        return result;
    }

    /**
     * 株価計算値を挿入する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkStockPriceCalcValueDto
     *                                    投資株式株価計算値ＤＴＯ
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     * @return 挿入数
     */
    public long insert(final ImStkStockPriceCalcValueDto imStkStockPriceCalcValueDto) throws KmgDomainException {

        long result = 0L;

        /* パラメータを設定する */
        imStkStockPriceCalcValueDto.setStartDate(LocalDate.MIN);
        imStkStockPriceCalcValueDto.setEndDate(LocalDate.MAX);
        imStkStockPriceCalcValueDto.setLocaleId("ja"); // TODO KenichiroArai 2021/05/01 列挙型
        imStkStockPriceCalcValueDto.setCreator("TSSTS_MAIN_USER"); // TODO KenichiroArai 2021/06/27 後で考える
        imStkStockPriceCalcValueDto.setCreatedDate(LocalDateTime.now());
        imStkStockPriceCalcValueDto.setUpdater("TSSTS_MAIN_USER"); // TODO KenichiroArai 2021/06/27 後で考える
        imStkStockPriceCalcValueDto.setUpdateDate(LocalDateTime.now());
        imStkStockPriceCalcValueDto.setNote(KmgString.EMPTY);
        imStkStockPriceCalcValueDto.setName(KmgString.EMPTY);

        final SqlParameterSource param = new BeanPropertySqlParameterSource(imStkStockPriceCalcValueDto);
        result = this.jdbc.update(ImStkStockPriceCalcValueDao.INSERT_SQL_PATH.toSql(), param);

        return result;

    }

}
