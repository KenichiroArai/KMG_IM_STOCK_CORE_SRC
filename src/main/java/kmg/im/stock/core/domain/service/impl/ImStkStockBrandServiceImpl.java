package kmg.im.stock.core.domain.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.ImStkStockBrandLogic;
import kmg.im.stock.core.domain.service.ImStkStockBrandService;

/**
 * 投資株式株銘柄サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkStockBrandServiceImpl implements ImStkStockBrandService {

    /** 投資株式株銘柄ロジック */
    private final ImStkStockBrandLogic imStkStockBrandLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkStockBrandLogic
     *                             投資株式株銘柄ロジック
     */
    public ImStkStockBrandServiceImpl(final ImStkStockBrandLogic imStkStockBrandLogic) {
        this.imStkStockBrandLogic = imStkStockBrandLogic;
    }

    /**
     * 株価銘柄IDを返す<br>
     * <p>
     * システム日付に該当する。
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandCode
     *                       株価銘柄コード
     * @return 株価銘柄ID
     */
    @Override
    public long getStockBrandId(final long stockBrandCode) {

        /* 株価銘柄IDを取得する */
        final long result = this.imStkStockBrandLogic.getStockBrandId(stockBrandCode);
        return result;
    }

    /**
     * 株価銘柄IDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandCode
     *                       株価銘柄コード
     * @param baseDate
     *                       基準日
     * @return 株価銘柄ID
     */
    @Override
    public long getStockBrandId(final long stockBrandCode, final LocalDate baseDate) {

        /* 株価銘柄IDを取得する */
        final long result = this.imStkStockBrandLogic.getStockBrandId(stockBrandCode, baseDate);
        return result;
    }

}
