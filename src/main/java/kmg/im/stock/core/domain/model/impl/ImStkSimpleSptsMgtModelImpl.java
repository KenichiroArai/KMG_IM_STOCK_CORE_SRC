package kmg.im.stock.core.domain.model.impl;

import java.util.ArrayList;
import java.util.List;

import kmg.core.infrastructure.utils.ListUtils;
import kmg.im.stock.core.domain.model.ImStkSimpleSptsMgtModel;
import kmg.im.stock.core.domain.model.ImStkSimpleSptsModel;

/**
 * 投資株式投資株式シンプル株価時系列モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSimpleSptsMgtModelImpl implements ImStkSimpleSptsMgtModel {

    /** 投資株式シンプル株価時系列モデルのリスト */
    private final List<ImStkSimpleSptsModel> dataList;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkSimpleSptsMgtModelImpl() {
        this.dataList = new ArrayList<>();
    }

    /**
     * 投資株式シンプル株価時系列モデルのリストをクリアする<br>
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
     * 投資株式シンプル株価時系列モデルのリストが空か<br>
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
     * 投資株式シンプル株価時系列モデルのリストが空ではないか<br>
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
     * 投資株式シンプル株価時系列モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式シンプル株価時系列モデル
     */
    @Override
    public void addData(final ImStkSimpleSptsModel data) {
        this.dataList.add(data);
    }

    /**
     * 投資株式シンプル株価時系列モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式シンプル株価時系列モデルのリスト
     */
    @Override
    public void addAllData(final List<ImStkSimpleSptsModel> addData) {
        if (ListUtils.isEmpty(addData)) {
            return;
        }

        this.dataList.addAll(addData);
    }

    /**
     * 投資株式シンプル株価時系列モデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式シンプル株価時系列モデルのリスト
     */
    @Override
    public List<ImStkSimpleSptsModel> getDataList() {
        final List<ImStkSimpleSptsModel> result = this.dataList;
        return result;
    }
}
