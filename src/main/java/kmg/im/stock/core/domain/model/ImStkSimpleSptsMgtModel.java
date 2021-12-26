package kmg.im.stock.core.domain.model;

import java.util.List;

/**
 * 投資株式シンプル株価時系列モデルインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSimpleSptsMgtModel {

    /**
     * 投資株式シンプル株価時系列モデルのリストをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    void clearDataList();

    /**
     * 投資株式シンプル株価時系列モデルのリストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    boolean isDataListEmpty();

    /**
     * 投資株式シンプル株価時系列モデルのリストが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    boolean isDataListNotEmpty();

    /**
     * 投資株式シンプル株価時系列モデルのを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式シンプル株価時系列モデル
     */
    void addData(ImStkSimpleSptsModel data);

    /**
     * 投資株式シンプル株価時系列モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式シンプル株価時系列モデルのリスト
     */
    void addAllData(List<ImStkSimpleSptsModel> addData);

    /**
     * 投資株式シンプル株価時系列モデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式シンプル株価時系列モデルのリスト
     */
    List<ImStkSimpleSptsModel> getDataList();
}
