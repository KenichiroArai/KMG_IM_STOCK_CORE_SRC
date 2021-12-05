package kmg.im.stock.core.data.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 株銘柄ＤＴＯインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface StockBrandDto {

    /**
     * 識別番号を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param id
     *           識別番号
     */
    void setId(Long id);

    /**
     * 識別番号を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 識別番号
     */
    Long getId();

    /**
     * 開始日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param startDate
     *                  開始日
     */
    void setStartDate(LocalDate startDate);

    /**
     * 開始日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 開始日
     */
    LocalDate getStartDate();

    /**
     * 終了日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param endDate
     *                終了日
     */
    void setEndDate(LocalDate endDate);

    /**
     * 終了日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 終了日
     */
    LocalDate getEndDate();

    /**
     * ロケールIDを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param localeId
     *                 ロケールID
     */
    void setLocaleId(String localeId);

    /**
     * ロケールIDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return ロケールID
     */
    String getLocaleId();

    /**
     * 作成者を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param creator
     *                作成者
     */
    void setCreator(String creator);

    /**
     * 作成者を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 作成者
     */
    String getCreator();

    /**
     * 作成日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param createdDate
     *                    作成日
     */
    void setCreatedDate(LocalTime createdDate);

    /**
     * 作成日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 作成日
     */
    LocalTime getCreatedDate();

    /**
     * 更新者を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param updater
     *                更新者
     */
    void setUpdater(String updater);

    /**
     * 更新者を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 更新者
     */
    String getUpdater();

    /**
     * 更新日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param updateDate
     *                   更新日
     */
    void setUpdateDate(LocalTime updateDate);

    /**
     * 更新日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 更新日
     */
    LocalTime getUpdateDate();

    /**
     * 備考を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param note
     *             備考
     */
    void setNote(String note);

    /**
     * 備考を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 備考
     */
    String getNote();

    /**
     * 名称を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param name
     *             名称
     */
    void setName(String name);

    /**
     * 名称を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 名称
     */
    String getName();

    /**
     * 株市場IDを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockMarketId
     *                      株市場ID
     */
    void setStockMarketId(Long stockMarketId);

    /**
     * 株市場IDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株市場ID
     */
    Long getStockMarketId();

    /**
     * コードを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param code
     *             コード
     */
    void setCode(Long code);

    /**
     * コードを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return コード
     */
    Long getCode();

    /**
     * 業種を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param industryType
     *                     業種
     */
    void setIndustryType(String industryType);

    /**
     * 業種を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 業種
     */
    String getIndustryType();

    /**
     * 特色を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param characteristic
     *                       特色
     */
    void setCharacteristic(String characteristic);

    /**
     * 特色を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 特色
     */
    String getCharacteristic();

    /**
     * 決算月を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param settlementOfAccountsMonth
     *                                  決算月
     */
    void setSettlementOfAccountsMonth(String settlementOfAccountsMonth);

    /**
     * 決算月を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 決算月
     */
    String getSettlementOfAccountsMonth();

    /**
     * 設立日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param establishmentDay
     *                         設立日
     */
    void setEstablishmentDay(LocalDate establishmentDay);

    /**
     * 設立日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 設立日
     */
    LocalDate getEstablishmentDay();

    /**
     * 上場日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param listedDay
     *                  上場日
     */
    void setListedDay(LocalDate listedDay);

    /**
     * 上場日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 上場日
     */
    LocalDate getListedDay();

    /**
     * 株主数を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockholdersNumber
     *                           株主数
     */
    void setStockholdersNumber(Long stockholdersNumber);

    /**
     * 株主数を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株主数
     */
    Long getStockholdersNumber();

    /**
     * 株式数を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stocksNumber
     *                     株式数
     */
    void setStocksNumber(Long stocksNumber);

    /**
     * 株式数を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株式数
     */
    Long getStocksNumber();

    /**
     * 単元数を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param unitsNumber
     *                    単元数
     */
    void setUnitsNumber(Long unitsNumber);

    /**
     * 単元数を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 単元数
     */
    Long getUnitsNumber();

}
