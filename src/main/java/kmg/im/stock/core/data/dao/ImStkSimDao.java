package kmg.im.stock.core.data.dao;

import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kmg.core.domain.model.KmgSqlPathModel;
import kmg.core.domain.model.impl.KmgSqlPathModelImpl;
import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.im.stock.core.data.dto.ImStkSimDto;
import kmg.im.stock.core.data.dto.ImStkStockBrandDto;
import kmg.im.stock.core.data.dto.impl.ImStkSimDtoImpl;
import kmg.im.stock.core.data.dto.impl.ImStkStockBrandDtoImpl;

/**
 * 投資株式シミュレーションＤＡＯ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Repository
@SuppressWarnings("nls")
public class ImStkSimDao {

    /** 検索するSQL */
    private static final KmgSqlPathModel FIND_SQL_PATH = new KmgSqlPathModelImpl(ImStkSimDao.class,
        Paths.get("find.sql"));

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
    public ImStkSimDao(final NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * 検索する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockCode
     *                  株価コード
     * @return 投資株式シミュレーションＤＴＯのリスト
     * @throws KmgDomainException
     *                            ＫＭＧドメイン例外
     */
    public List<ImStkSimDto> find(final long stockCode) throws KmgDomainException {

        List<ImStkSimDto> result = null;

        /* パラメータを設定する */
        final ImStkStockBrandDto imStkStockBrandDto = new ImStkStockBrandDtoImpl();
        imStkStockBrandDto.setCode(stockCode);

        /* DBを実行する */
        final SqlParameterSource params = new BeanPropertySqlParameterSource(imStkStockBrandDto);
        final List<ImStkSimDtoImpl> tmp = this.jdbc.query(ImStkSimDao.FIND_SQL_PATH.toSql(), params,
            BeanPropertyRowMapper.newInstance(ImStkSimDtoImpl.class));
        result = tmp.stream().map(mapper -> (ImStkSimDto) mapper).collect(Collectors.toList());

        return result;

    }
}
