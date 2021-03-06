package kmg.im.stock.core.domain.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import kmg.core.infrastructure.utils.KmgListUtils;
import kmg.im.stock.core.domain.model.ImStkSpcvInitMgtModel;
import kmg.im.stock.core.domain.model.ImStkSpcvInitModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceCalcValueMgtModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceCalcValueModel;
import kmg.im.stock.core.infrastructure.types.ImStkStockPriceCalcValueTypeTypes;

/**
 * 投資株式株価計算値管理モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkStockPriceCalcValueMgtModelImpl implements ImStkStockPriceCalcValueMgtModel {

    /** 株価計算値リスト */
    private final List<ImStkStockPriceCalcValueModel> dataList;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkStockPriceCalcValueMgtModelImpl() {
        this.dataList = new ArrayList<>();
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkSpcvInitMgtModel
     *                              投資株式株価計算値初期化管理モデル
     * @param spcvt
     *                              投資株式株価計算値の種類の種類
     * @param supplierList
     *                              サプライヤリスト
     */
    public ImStkStockPriceCalcValueMgtModelImpl(final ImStkSpcvInitMgtModel imStkSpcvInitMgtModel,
        final ImStkStockPriceCalcValueTypeTypes spcvt, final List<Supplier<BigDecimal>> supplierList) {
        this();

        for (int i = 0; i < imStkSpcvInitMgtModel.getDataList().size(); i++) {
            final ImStkSpcvInitModel tsstsSpcvInitModel = imStkSpcvInitMgtModel.getDataList().get(i);
            final Supplier<BigDecimal> supplier = supplierList.get(i);
            final ImStkStockPriceCalcValueModel data = new ImStkStockPriceCalcValueModelImpl();
            data.setSptsId(tsstsSpcvInitModel.getId());
            data.setSpcvtId(spcvt);
            data.setCalcValue(supplier.get());

            // 株価計算値リストに追加
            this.dataList.add(data);
        }
    }

    /**
     * 株価計算値リストをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Override
    public void clearDataList() {
        this.dataList.clear();
    }

    /**
     * 株価計算値リストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    @Override
    public boolean isDataListEmpty() {
        boolean result = true;

        if (KmgListUtils.isEmpty(this.dataList)) {
            return result;
        }

        result = false;
        return result;
    }

    /**
     * 株価計算値リストが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    @Override
    public boolean isDataListNotEmpty() {
        final boolean result = !this.isDataListEmpty();
        return result;
    }

    /**
     * 株価データを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             株価データ
     */
    @Override
    public void addData(final ImStkStockPriceCalcValueModel data) {
        this.dataList.add(data);
    }

    /**
     * 株価計算値リストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加株価計算値リスト
     */
    @Override
    public void addAllData(final List<ImStkStockPriceCalcValueModel> addData) {
        if (KmgListUtils.isEmpty(addData)) {
            return;
        }

        this.dataList.addAll(addData);
    }

    /**
     * 株価計算値リストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価計算値リスト
     */
    @Override
    public List<ImStkStockPriceCalcValueModel> getDataList() {
        final List<ImStkStockPriceCalcValueModel> result = this.dataList;
        return result;
    }

}
