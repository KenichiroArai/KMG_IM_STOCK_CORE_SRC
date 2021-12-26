package kmg.im.stock.core.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Supplier;

/**
 * 投資株式株価時系列登録データ管理モデルインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSptsMainDataMgtModel {

    /**
     * 投資株式株価時系列登録データモデルのリストをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    void clearDataList();

    /**
     * 投資株式株価時系列登録データモデルのリストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    boolean isDataListEmpty();

    /**
     * 投資株式株価時系列登録データモデルのリストが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    boolean isDataListNotEmpty();

    /**
     * 投資株式株価時系列登録データモデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式株価時系列登録データモデル
     */
    void addData(ImStkSptsRegDataModel data);

    /**
     * 投資株式株価時系列登録データモデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価時系列登録データモデルのリスト
     */
    void addAllData(List<ImStkSptsRegDataModel> addData);

    /**
     * 投資株式株価時系列登録データモデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価時系列登録データモデルのリスト
     */
    List<ImStkSptsRegDataModel> getDataList();

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
    List<ImStkPowerIndexCalcModel> toImStkPowerIndexCalcModelList();
}
