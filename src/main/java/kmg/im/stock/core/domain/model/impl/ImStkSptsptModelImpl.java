package kmg.im.stock.core.domain.model.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import kmg.core.infrastructure.utils.KmgListUtils;
import kmg.core.infrastructure.utils.KmgMapUtils;
import kmg.im.stock.core.domain.model.ImStkPowerIndexCalcModel;
import kmg.im.stock.core.domain.model.ImStkSptsptModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceTimeSeriesModel;
import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列期間の種類モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSptsptModelImpl implements ImStkSptsptModel {

    // TODO KenichiroArai 2021/09/12 投資株式期間の種類の種類の論理名と物理名を株価時系列投資株式期間の種類の種類に変更する
    /** 投資株式期間の種類の種類 */
    private final ImStkPeriodTypeTypes imStkPeriodTypeTypes;

    /**
     * 投資株式株価時系列モデルのマップ<br>
     * <p>
     * キー：番号<br>
     * 値：投資株式株価時系列モデル<br>
     * </p>
     */
    private final SortedMap<Long, ImStkStockPriceTimeSeriesModel> sptsModelMap;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkPeriodTypeTypes
     *                             投資株式期間の種類の種類
     */
    public ImStkSptsptModelImpl(final ImStkPeriodTypeTypes imStkPeriodTypeTypes) {
        this.sptsModelMap = new TreeMap<>();
        this.imStkPeriodTypeTypes = imStkPeriodTypeTypes;
    }

    /**
     * 投資株式期間の種類の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式期間の種類の種類
     */
    @Override
    public ImStkPeriodTypeTypes getImStkPeriodTypeTypes() {
        final ImStkPeriodTypeTypes result = this.imStkPeriodTypeTypes;
        return result;
    }

    /**
     * 投資株式株価時系列モデルのマップをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Override
    public void clearSptsModelMap() {
        this.sptsModelMap.clear();
    }

    /**
     * 投資株式株価時系列モデルのマップが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    @Override
    public boolean isSptsModelMapEmpty() {
        boolean result = true;

        if (KmgMapUtils.isEmpty(this.sptsModelMap)) {
            return result;
        }

        result = false;
        return result;
    }

    /**
     * 投資株式株価時系列モデルのマップが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    @Override
    public boolean isSptsModelMapNotEmpty() {
        final boolean result = !this.isSptsModelMapEmpty();
        return result;
    }

    /**
     * 投資株式株価時系列モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsModel
     *                  投資株式株価時系列モデル
     */
    @Override
    public void addSptsModel(final ImStkStockPriceTimeSeriesModel sptsModel) {
        this.sptsModelMap.put(sptsModel.getNo(), sptsModel);
    }

    /**
     * 投資株式株価時系列モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsModelList
     *                      投資株式株価時系列モデルのリスト
     */
    @Override
    public void addAllSptsModelList(final List<ImStkStockPriceTimeSeriesModel> sptsModelList) {
        if (KmgListUtils.isEmpty(sptsModelList)) {
            return;
        }

        for (final ImStkStockPriceTimeSeriesModel sptsModel : sptsModelList) {
            this.addSptsModel(sptsModel);
        }
    }

    /**
     * 投資株式株価時系列モデルのマップを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価時系列マップ
     */
    @Override
    public SortedMap<Long, ImStkStockPriceTimeSeriesModel> getSptsModelMap() {
        final SortedMap<Long, ImStkStockPriceTimeSeriesModel> result = this.sptsModelMap;
        return result;
    }

    /**
     * 番号に該当する投資株式株価時系列モデルを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param no
     *           番号
     * @return 株価時系列マップ
     */
    @Override
    public ImStkStockPriceTimeSeriesModel getSptsModel(final long no) {
        final ImStkStockPriceTimeSeriesModel result = this.sptsModelMap.get(no);
        return result;
    }

    /**
     * 投資株式株価時系列モデルの全リストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価時系列モデルのリスト
     */
    @Override
    public List<ImStkStockPriceTimeSeriesModel> toAllSptsModelList() {
        final List<ImStkStockPriceTimeSeriesModel> result = this.sptsModelMap.values().stream()
            .collect(Collectors.toList());
        return result;
    }

    /**
     * サプライヤの全リストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return サプライヤリスト
     */
    @Override
    public List<Supplier<BigDecimal>> toAllSupplierList() {
        final List<Supplier<BigDecimal>> result = this.sptsModelMap.values().stream().collect(Collectors.toList());
        return result;
    }

    /**
     * 投資株式勢力指数計算モデルの全リストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式勢力指数計算モデルのリスト
     */
    @Override
    public List<ImStkPowerIndexCalcModel> toAllImStkPowerIndexCalcModelList() {
        final List<ImStkPowerIndexCalcModel> result = this.sptsModelMap.values().stream().collect(Collectors.toList());
        return result;
    }

}
