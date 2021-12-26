package kmg.im.stock.core.domain.model;

import java.util.List;

/**
 * 投資株式株価生データ取得管理モデルインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSpRawDataAcqMgtModel {

    /**
     * 株価銘柄コードを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandCode
     *                       株価銘柄コード
     */
    void setStockBrandCode(final long stockBrandCode);

    /**
     * 株価銘柄コードを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価銘柄コード
     */
    long getStockBrandCode();

    /**
     * 投資株式株価生データ取得モデルのリストをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    void clearDataList();

    /**
     * 投資株式株価生データ取得モデルのリストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    boolean isDataListEmpty();

    /**
     * 投資株式株価生データ取得モデルのリストが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    boolean isDataListNotEmpty();

    /**
     * 投資株式株価生データ取得モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式株価生データ取得モデル
     */
    void addData(ImStkSpRawDataAcqModel data);

    /**
     * 投資株式株価生データ取得モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価生データ取得モデルのリスト
     */
    void addAllData(List<ImStkSpRawDataAcqModel> addData);

    /**
     * 投資株式株価生データ取得モデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価生データ取得モデルのリスト
     */
    List<ImStkSpRawDataAcqModel> getDataList();
}
