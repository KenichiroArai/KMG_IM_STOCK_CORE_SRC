package kmg.im.stock.core.domain.service.impl;

import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.ImStkStockPriceCalcValueLogic;
import kmg.im.stock.core.domain.model.StockPriceCalcValueMgtModel;
import kmg.im.stock.core.domain.service.ImStkStockPriceCalcValueService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;

/**
 * 投資株式株価計算値サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class ImStkStockPriceCalcValueServiceImpl implements ImStkStockPriceCalcValueService {

    /** 投資株式投資株式株価計算値ロジック */
    private final ImStkStockPriceCalcValueLogic imStkStockPriceCalcValueLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkStockPriceCalcValueLogic
     *                                      投資株式投資株式株価計算値ロジック
     */
    public ImStkStockPriceCalcValueServiceImpl(final ImStkStockPriceCalcValueLogic imStkStockPriceCalcValueLogic) {
        this.imStkStockPriceCalcValueLogic = imStkStockPriceCalcValueLogic;
    }

    /**
     * 登録する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceCalcValueMgtModel
     *                                    株価計算値管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public void register(final StockPriceCalcValueMgtModel stockPriceCalcValueMgtModel) throws ImStkDomainException {
        this.imStkStockPriceCalcValueLogic.register(stockPriceCalcValueMgtModel);
    }

}
