package kmg.im.stock.core.data.dao;

import java.time.LocalDate;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kmg.im.stock.core.data.dto.ImStkStockBrandDto;
import kmg.im.stock.core.data.dto.impl.ImStkStockBrandDtoImpl;

/**
 * 投資株式株銘柄ＤＡＯ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Repository
@SuppressWarnings("nls")
public class ImStkStockBrandDao {

    /** 識別番号を取得するSQL */
    private static final String GET_ID_SQL = "SELECT id FROM stock_brand WHERE start_date <= :startDate AND end_date > :startDate AND code = :code";

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
    public ImStkStockBrandDao(final NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * 識別番号を取得する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandCode
     *                       株価銘柄コード
     * @param baseDate
     *                       基準日
     * @return 識別番号
     */
    public long getId(final long stockBrandCode, final LocalDate baseDate) {

        long result = 0L;

        /* パラメータを設定する */
        final ImStkStockBrandDto imStkStockBrandDto = new ImStkStockBrandDtoImpl();
        imStkStockBrandDto.setCode(stockBrandCode);
        imStkStockBrandDto.setStartDate(baseDate);

        /* DBを実行する */
        final SqlParameterSource params = new BeanPropertySqlParameterSource(imStkStockBrandDto);
        result = this.jdbc.queryForObject(ImStkStockBrandDao.GET_ID_SQL, params, Long.class);

        return result;

    }
}
