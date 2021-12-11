package kmg.im.stock.core.domain.service.impl;

import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.StockPriceCalcValueLogic;
import kmg.im.stock.core.domain.model.StockPriceCalcValueMgtModel;
import kmg.im.stock.core.domain.service.StockPriceCalcValueService;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;

/**
 * 株価計算値サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class StockPriceCalcValueServiceImpl implements StockPriceCalcValueService {

    /** 登録ロジック */
    private final StockPriceCalcValueLogic stockPriceCalcValueLogic;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceCalcValueLogic
     *                                 登録ロジック
     */
    public StockPriceCalcValueServiceImpl(final StockPriceCalcValueLogic stockPriceCalcValueLogic) {
        this.stockPriceCalcValueLogic = stockPriceCalcValueLogic;
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
        this.stockPriceCalcValueLogic.register(stockPriceCalcValueMgtModel);
    }

}