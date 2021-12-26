package kmg.im.stock.core.domain.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.SortedMap;
import java.util.function.Supplier;

import kmg.im.stock.core.infrastructure.types.ImStkPeriodTypeTypes;

/**
 * 投資株式株価時系列期間の種類モデルインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSptsptModel {

    /**
     * 投資株式期間の種類の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式期間の種類の種類
     */
    ImStkPeriodTypeTypes getImStkPeriodTypeTypes();

    /**
     * 株価時系列モデルのマップをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    void clearSptsModelMap();

    /**
     * 株価時系列モデルのマップが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    boolean isSptsModelMapEmpty();

    /**
     * 株価時系列モデルのマップが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    boolean isSptsModelMapNotEmpty();

    /**
     * 株価時系列モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsModel
     *                  株価時系列モデル
     */
    void addSptsModel(final ImStkStockPriceTimeSeriesModel sptsModel);

    /**
     * 投資株式勢力指数計算モデルを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsModelList
     *                      投資株式勢力指数計算モデル
     */
    void addAllSptsModelList(final List<ImStkStockPriceTimeSeriesModel> sptsModelList);

    /**
     * 株価時系列モデルのマップを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価時系列マップ
     */
    SortedMap<Long, ImStkStockPriceTimeSeriesModel> getSptsModelMap();

    /**
     * 番号に該当する株価時系列モデルを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param no
     *           番号
     * @return 株価時系列マップ
     */
    ImStkStockPriceTimeSeriesModel getSptsModel(final long no);

    /**
     * 株価時系列モデルの全リストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式勢力指数計算モデル
     */
    List<ImStkStockPriceTimeSeriesModel> toAllSptsModelList();

    /**
     * サプライヤの全リストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return サプライヤリスト
     */
    List<Supplier<BigDecimal>> toAllSupplierList();

    /**
     * 勢力指数計算モデルの全リストとして返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 勢力指数計算モデルのリスト
     */
    List<ImStkPowerIndexCalcModel> toAllImStkPowerIndexCalcModelList();

}
