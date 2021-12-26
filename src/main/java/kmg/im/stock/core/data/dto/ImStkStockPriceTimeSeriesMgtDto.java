package kmg.im.stock.core.data.dto;

import java.util.List;

/**
 * 投資株式投資株式株価時系列管理ＤＴＯインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
//TODO KenichiroArai 2021/05/29 ベースとなるクラスを作成する
public interface ImStkStockPriceTimeSeriesMgtDto {

    /**
     * 投資株式株価時系列リストをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    void clearDataList();

    /**
     * 投資株式株価時系列リストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    boolean isDataListEmpty();

    /**
     * 投資株式株価時系列リストが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    boolean isDataListNotEmpty();

    /**
     * 投資株式株価時系列を追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式株価時系列
     */
    void addData(ImStkStockPriceTimeSeriesDto data);

    /**
     * 投資株式株価時系列リストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価時系列リスト
     */
    void addAllData(List<ImStkStockPriceTimeSeriesDto> addData);

    /**
     * 投資株式株価時系列リストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価時系列リスト
     */
    List<ImStkStockPriceTimeSeriesDto> getDataList();

}
