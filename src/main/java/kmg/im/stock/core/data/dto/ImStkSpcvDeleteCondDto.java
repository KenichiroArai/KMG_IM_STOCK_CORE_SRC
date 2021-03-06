package kmg.im.stock.core.data.dto;

/**
 * 投資株式株価計算値削除条件ＤＴＯインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSpcvDeleteCondDto {

    /**
     * 株価銘柄ＩＤを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandId
     *                     株価銘柄ＩＤ
     */
    void setStockBrandId(long stockBrandId);

    /**
     * 株価銘柄ＩＤを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価銘柄ＩＤ
     */
    long getStockBrandId();

    /**
     * 期間の種類ＩＤを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param periodTypeId
     *                     期間の種類ＩＤ
     */
    void setPeriodTypeId(long periodTypeId);

    /**
     * 期間の種類ＩＤを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 期間の種類ＩＤ
     */
    long getPeriodTypeId();

}
