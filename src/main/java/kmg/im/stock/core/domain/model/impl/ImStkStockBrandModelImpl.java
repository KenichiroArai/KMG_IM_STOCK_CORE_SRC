package kmg.im.stock.core.domain.model.impl;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import kmg.core.infrastructure.utils.KmgListUtils;
import kmg.core.infrastructure.utils.KmgMapUtils;
import kmg.im.stock.core.domain.model.ImStkSptsptModel;
import kmg.im.stock.core.domain.model.ImStkStockBrandModel;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株銘柄モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkStockBrandModelImpl implements ImStkStockBrandModel {

    /** 株銘柄ID */
    private long stockBrandId;

    /** 株価銘柄コード */
    private long stockBrandCode;

    /** 投資株式株価時系列期間の種類のマップ */
    private final SortedMap<ImStkPeriodTypeTypes, ImStkSptsptModel> sptsptMap;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkStockBrandModelImpl() {
        this.sptsptMap = new TreeMap<>();
    }

    /**
     * 株銘柄IDを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                     株銘柄ID
     */
    @Override
    public void setStockBrandId(final long stockBrandId) {
        this.stockBrandId = stockBrandId;
    }

    /**
     * 株銘柄IDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株銘柄ID
     */
    @Override
    public long getStockBrandId() {
        final long result = this.stockBrandId;
        return result;
    }

    /**
     * 株価銘柄コードを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandCode
     *                       株価銘柄コード
     */
    @Override
    public void setStockBrandCode(final long stockBrandCode) {
        this.stockBrandCode = stockBrandCode;
    }

    /**
     * 株価銘柄コードを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価銘柄コード
     */
    @Override
    public long getStockBrandCode() {
        final long result = this.stockBrandCode;
        return result;
    }

    /**
     * 投資株式株価時系列期間の種類のマップをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Override
    public void clearSptspMap() {
        this.sptsptMap.clear();
    }

    /**
     * 投資株式株価時系列期間の種類のマップが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    @Override
    public boolean isSptspMapEmpty() {
        boolean result = true;

        if (KmgMapUtils.isEmpty(this.sptsptMap)) {
            return result;
        }

        result = false;
        return result;
    }

    /**
     * 投資株式株価時系列期間の種類のマップが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    @Override
    public boolean isSptspMapNotEmpty() {
        final boolean result = !this.isSptspMapEmpty();
        return result;
    }

    /**
     * 投資株式株価時系列期間の種類モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsptModel
     *                    投資株式株価時系列期間の種類モデル
     */
    @Override
    public void addImStkSptsptModel(final ImStkSptsptModel sptsptModel) {
        this.sptsptMap.put(sptsptModel.getImStkPeriodTypeTypes(), sptsptModel);
    }

    /**
     * 投資株式株価時系列期間の種類モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsptModelList
     *                        投資株式株価時系列期間の種類モデルのリスト
     */
    @Override
    public void addAllImStkSptsptModel(final List<ImStkSptsptModel> sptsptModelList) {
        if (KmgListUtils.isEmpty(sptsptModelList)) {
            return;
        }

        for (final ImStkSptsptModel sptsptModel : sptsptModelList) {
            this.addImStkSptsptModel(sptsptModel);
        }
    }

    /**
     * 投資株式株価時系列期間の種類モデルのマップを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価時系列期間の種類モデルのマップ
     */
    @Override
    public SortedMap<ImStkPeriodTypeTypes, ImStkSptsptModel> getImStkSptsptModelMap() {
        final SortedMap<ImStkPeriodTypeTypes, ImStkSptsptModel> result = this.sptsptMap;
        return result;
    }

    /**
     * 投資株式期間の種類の種類に該当する投資株式株価時系列期間の種類モデルを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param periodTypeTypes
     *                        投資株式期間の種類の種類
     * @return 投資株式株価時系列期間の種類モデル
     */
    @Override
    public ImStkSptsptModel getImStkSptsptModel(final ImStkPeriodTypeTypes periodTypeTypes) {
        final ImStkSptsptModel result = this.sptsptMap.get(periodTypeTypes);
        return result;
    }

    /**
     * 投資株式株価時系列期間の種類モデルのリストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価時系列期間の種類モデルのリスト
     */
    @Override
    public List<ImStkSptsptModel> toImStkSptsptModelList() {
        final List<ImStkSptsptModel> result = this.sptsptMap.values().stream().collect(Collectors.toList());
        return result;
    }

}
