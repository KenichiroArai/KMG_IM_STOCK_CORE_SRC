package kmg.im.stock.core.domain.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import kmg.core.infrastructure.utils.ListUtils;
import kmg.im.stock.core.domain.model.ImStkSpcvInitMgtModel;
import kmg.im.stock.core.domain.model.ImStkSpcvInitModel;
import kmg.im.stock.core.domain.model.PowerIndexCalcModel;
import kmg.im.stock.core.domain.model.SimpleSptsMgtModel;
import kmg.im.stock.core.domain.model.SimpleSptsModel;

/**
 * 投資株式株価計算値初期化管理モデルインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSpcvInitMgtModelImpl implements ImStkSpcvInitMgtModel {

    /** 投資株式株価計算値初期化モデルのリスト */
    private final List<ImStkSpcvInitModel> dataList;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkSpcvInitMgtModelImpl() {
        this.dataList = new ArrayList<>();
    }

    /**
     * シンプル株価時系列管理モデルを取り込む<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param simpleSptsMgtDailyModel
     *                                シンプル株価時系列管理モデル
     */
    @Override
    public void from(final SimpleSptsMgtModel simpleSptsMgtDailyModel) {
        for (final SimpleSptsModel simpleSptsModel : simpleSptsMgtDailyModel.getDataList()) {
            final ImStkSpcvInitModel tsstsSpcvInitModel = new ImStkSpcvInitModelImpl();
            BeanUtils.copyProperties(simpleSptsModel, tsstsSpcvInitModel);
            this.dataList.add(tsstsSpcvInitModel);
        }
    }

    /**
     * 投資株式株価計算値初期化モデルのリストをクリアする<br>
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
     * 投資株式株価計算値初期化モデルのリストが空か<br>
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
     * 投資株式株価計算値初期化モデルのリストが空ではないか<br>
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
     * 投資株式株価計算値初期化モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式株価計算値初期化モデル
     */
    @Override
    public void addData(final ImStkSpcvInitModel data) {
        this.dataList.add(data);
    }

    /**
     * 投資株式株価計算値初期化モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価計算値初期化モデルのリスト
     */
    @Override
    public void addAllData(final List<ImStkSpcvInitModel> addData) {
        if (ListUtils.isEmpty(addData)) {
            return;
        }

        this.dataList.addAll(addData);
    }

    /**
     * 投資株式株価計算値初期化モデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価計算値初期化モデルのリスト
     */
    @Override
    public List<ImStkSpcvInitModel> getDataList() {
        final List<ImStkSpcvInitModel> result = this.dataList;
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
     * 勢力指数計算モデルリストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 勢力指数計算モデルリスト
     */
    @Override
    public List<PowerIndexCalcModel> toPowerIndexCalcModelList() {
        final List<PowerIndexCalcModel> result = this.dataList.stream().collect(Collectors.toList());
        return result;
    }

}
