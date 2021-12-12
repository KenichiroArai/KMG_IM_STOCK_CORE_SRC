package kmg.im.stock.core.domain.logic.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import kmg.core.infrastructure.exception.KmgDomainException;
import kmg.im.stock.core.data.dao.StockPriceCalcValueDao;
import kmg.im.stock.core.data.dto.StockPriceCalcValueDto;
import kmg.im.stock.core.data.dto.impl.StockPriceCalcValueDtoImpl;
import kmg.im.stock.core.domain.logic.StockPriceCalcValueLogic;
import kmg.im.stock.core.domain.model.StockPriceCalcValueMgtModel;
import kmg.im.stock.core.domain.model.StockPriceCalcValueModel;
import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;
import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 株価計算値ロジック<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
public class StockPriceCalcValueLogicImpl implements StockPriceCalcValueLogic {

    /** 株価計算値ＤＡＯ */
    private final StockPriceCalcValueDao stockPriceCalcValueDao;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockPriceCalcValueDao
     *                               株価計算値ＤＡＯ
     */
    public StockPriceCalcValueLogicImpl(final StockPriceCalcValueDao stockPriceCalcValueDao) {
        this.stockPriceCalcValueDao = stockPriceCalcValueDao;
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
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public long deleteBySbIdAndImStkPeriodTypeTypes(final long sbId, final ImStkPeriodTypeTypes periodTypeTypes)
        throws ImStkDomainException {
        long result = 0;
        try {
            result = this.stockPriceCalcValueDao.deleteByIdCdAndImStkPeriodTypeTypes(sbId, periodTypeTypes);
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/11 例外処理
            final String errMsg = "";
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
     * @param stockPriceCalcValueMgtModel
     *                                    株価計算値管理モデル
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    @Override
    public void register(final StockPriceCalcValueMgtModel stockPriceCalcValueMgtModel) throws ImStkDomainException {
        try {

            for (final StockPriceCalcValueModel stockPriceCalcValueModel : stockPriceCalcValueMgtModel.getDataList()) {

                final StockPriceCalcValueDto stockPriceCalcValueDto = new StockPriceCalcValueDtoImpl();
                BeanUtils.copyProperties(stockPriceCalcValueModel, stockPriceCalcValueDto);
                stockPriceCalcValueDto.setSpcvtId(stockPriceCalcValueModel.getSpcvtId().get());

                this.stockPriceCalcValueDao.insert(stockPriceCalcValueDto);
            }
        } catch (final KmgDomainException e) {
            // TODO KenichiroArai 2021/06/27 例外処理
            final String errMsg = "";
            final ImStkLogMessageTypes logMsgTypes = ImStkLogMessageTypes.NONE;
            final Object[] logMsgArg = {};
            throw new ImStkDomainException(errMsg, logMsgTypes, logMsgArg, e);
        }
    }

}
