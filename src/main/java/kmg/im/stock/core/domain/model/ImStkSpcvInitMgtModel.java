package kmg.im.stock.core.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;

/**
 * 投資株式株価計算値初期化管理モデルインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSpcvInitMgtModel {

    /**
     * シンプル株価時系列管理モデルを取り込む<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param simpleSptsMgtDailyModel
     *                                シンプル株価時系列管理モデル
     */
    void from(SimpleSptsMgtModel simpleSptsMgtDailyModel);

    /**
     * 投資株式株価計算値初期化モデルのリストをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    void clearDataList();

    /**
     * 投資株式株価計算値初期化モデルのリストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    boolean isDataListEmpty();

    /**
     * 投資株式株価計算値初期化モデルのリストが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    boolean isDataListNotEmpty();

    /**
     * 投資株式株価計算値初期化モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式株価計算値初期化モデル
     */
    void addData(ImStkSpcvInitModel data);

    /**
     * 投資株式株価計算値初期化モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価計算値初期化モデルのリスト
     */
    void addAllData(List<ImStkSpcvInitModel> addData);

    /**
     * 投資株式株価計算値初期化モデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価計算値初期化モデルのリスト
     */
    List<ImStkSpcvInitModel> getDataList();

    /**
     * サプライヤデータリストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return サプライヤデータリスト
     */
    List<Supplier<BigDecimal>> toSupplierDataList();

    /**
     * 勢力指数計算モデルリストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 勢力指数計算モデルリスト
     */
    List<PowerIndexCalcModel> toPowerIndexCalcModelList();
}
