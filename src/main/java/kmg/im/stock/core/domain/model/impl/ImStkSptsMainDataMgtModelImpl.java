package kmg.im.stock.core.domain.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import kmg.core.infrastructure.utils.ListUtils;
import kmg.im.stock.core.domain.model.ImStkPowerIndexCalcModel;
import kmg.im.stock.core.domain.model.ImStkSptsMainDataMgtModel;
import kmg.im.stock.core.domain.model.ImStkSptsRegDataModel;

/**
 * 投資株式投資株式株価時系列登録データ管理モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSptsMainDataMgtModelImpl implements ImStkSptsMainDataMgtModel {

    /** 投資株式株価時系列登録データ管理モデルのリスト */
    private final List<ImStkSptsRegDataModel> dataList;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkSptsMainDataMgtModelImpl() {
        this.dataList = new ArrayList<>();
    }

    /**
     * 投資株式株価時系列登録データ管理モデルのリストをクリアする<br>
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
     * 投資株式株価時系列登録データ管理モデルのリストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    @Override
    public boolean isDataListEmpty() {
        boolean result = true;

        if (ListUtils.isEmpty(this.dataList)) {
            return result;
        }

        result = false;
        return result;
    }

    /**
     * 投資株式株価時系列登録データ管理モデルのリストが空ではないか<br>
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
     * 投資株式株価時系列登録データ管理モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式株価時系列登録データ管理モデル
     */
    @Override
    public void addData(final ImStkSptsRegDataModel data) {
        this.dataList.add(data);
    }

    /**
     * 投資株式株価時系列登録データ管理モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価時系列登録データ管理モデルのリスト
     */
    @Override
    public void addAllData(final List<ImStkSptsRegDataModel> addData) {
        if (ListUtils.isEmpty(addData)) {
            return;
        }

        this.dataList.addAll(addData);
    }

    /**
     * 投資株式株価時系列登録データ管理モデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価時系列登録データ管理モデルのリスト
     */
    @Override
    public List<ImStkSptsRegDataModel> getDataList() {
        final List<ImStkSptsRegDataModel> result = this.dataList;
        return result;
    }

    /**
     * サプライヤデータリストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return サプライヤデータリスト
     */
    @Override
    public List<Supplier<BigDecimal>> toSupplierDataList() {

        final List<Supplier<BigDecimal>> result = this.dataList.stream().collect(Collectors.toList());
        return result;
    }

    /**
     * 投資株式勢力指数計算モデルのリストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式勢力指数計算モデルのリスト
     */
    @Override
    public List<ImStkPowerIndexCalcModel> toImStkPowerIndexCalcModelList() {
        final List<ImStkPowerIndexCalcModel> result = this.dataList.stream().collect(Collectors.toList());
        return result;
    }

}
