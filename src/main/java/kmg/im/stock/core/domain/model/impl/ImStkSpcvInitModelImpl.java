package kmg.im.stock.core.domain.model.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import kmg.im.stock.core.domain.model.ImStkSpcvInitModel;

/**
 * 投資株式株価計算値初期化モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSpcvInitModelImpl implements ImStkSpcvInitModel {

    /** 識別番号 */
    private long id;

    /** 開始日 */
    private LocalDate startDate;

    /** 終了日 */
    private LocalDate endDate;

    /** ロケールID */
    private String localeId;

    /** 作成者 */
    private String creator;

    /** 作成日 */
    private LocalDateTime createdDate;

    /** 更新者 */
    private String updater;

    /** 更新日 */
    private LocalDateTime updateDate;

    /** 備考 */
    private String note;

    /** 名称 */
    private String name;

    /** 株価時系列期間の種類ID */
    private long sptsptId;

    /** 番号 */
    private long no;

    /** 期間開始日 */
    private LocalDate periodStartDate;

    /** 期間終了日 */
    private LocalDate periodEndDate;

    /** 始値 */
    private BigDecimal op;

    /** 高値 */
    private BigDecimal hp;

    /** 安値 */
    private BigDecimal lp;

    /** 終値 */
    private BigDecimal cp;

    /** 出来高 */
    private long volume;

    /**
     * 識別番号を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param id
     *           識別番号
     */
    @Override
    public void setId(final long id) {
        this.id = id;
    }

    /**
     * 識別番号を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 識別番号
     */
    @Override
    public long getId() {
        final long result = this.id;
        return result;
    }

    /**
     * 開始日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param startDate
     *                  開始日
     */
    @Override
    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * 開始日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 開始日
     */
    @Override
    public LocalDate getStartDate() {
        final LocalDate result = this.startDate;
        return result;
    }

    /**
     * 終了日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param endDate
     *                終了日
     */
    @Override
    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * 終了日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 終了日
     */
    @Override
    public LocalDate getEndDate() {
        final LocalDate result = this.endDate;
        return result;
    }

    /**
     * ロケールIDを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param localeId
     *                 ロケールID
     */
    @Override
    public void setLocaleId(final String localeId) {
        this.localeId = localeId;
    }

    /**
     * ロケールIDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return ロケールID
     */
    @Override
    public String getLocaleId() {
        final String result = this.localeId;
        return result;
    }

    /**
     * 作成者を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param creator
     *                作成者
     */
    @Override
    public void setCreator(final String creator) {
        this.creator = creator;
    }

    /**
     * 作成者を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 作成者
     */
    @Override
    public String getCreator() {
        final String result = this.creator;
        return result;
    }

    /**
     * 作成日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param createdDate
     *                    作成日
     */
    @Override
    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 作成日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 作成日
     */
    @Override
    public LocalDateTime getCreatedDate() {
        final LocalDateTime result = this.createdDate;
        return result;
    }

    /**
     * 更新者を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param updater
     *                更新者
     */
    @Override
    public void setUpdater(final String updater) {
        this.updater = updater;
    }

    /**
     * 更新者を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 更新者
     */
    @Override
    public String getUpdater() {
        final String result = this.updater;
        return result;
    }

    /**
     * 更新日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param updateDate
     *                   更新日
     */
    @Override
    public void setUpdateDate(final LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 更新日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 更新日
     */
    @Override
    public LocalDateTime getUpdateDate() {
        final LocalDateTime result = this.updateDate;
        return result;
    }

    /**
     * 備考を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param note
     *             備考
     */
    @Override
    public void setNote(final String note) {
        this.note = note;
    }

    /**
     * 備考を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 備考
     */
    @Override
    public String getNote() {
        final String result = this.note;
        return result;
    }

    /**
     * 名称を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param name
     *             名称
     */
    @Override
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * 名称を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 名称
     */
    @Override
    public String getName() {
        final String result = this.name;
        return result;
    }

    /**
     * 株価時系列期間の種類IDを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param sptsptId
     *                 株価時系列期間の種類ID
     */
    @Override
    public void setSptsptId(final long sptsptId) {
        this.sptsptId = sptsptId;
    }

    /**
     * 株価時系列期間の種類IDを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価時系列期間の種類ID
     */
    @Override
    public long getSptsptId() {
        final long result = this.sptsptId;
        return result;
    }

    /**
     * 番号を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param no
     *           番号
     */
    @Override
    public void setNo(final long no) {
        this.no = no;
    }

    /**
     * 番号を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 番号
     */
    @Override
    public long getNo() {
        final long result = this.no;
        return result;
    }

    /**
     * 期間開始日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param periodStartDate
     *                        期間開始日
     */
    @Override
    public void setPeriodStartDate(final LocalDate periodStartDate) {
        this.periodStartDate = periodStartDate;
    }

    /**
     * 期間開始日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 期間開始日
     */
    @Override
    public LocalDate getPeriodStartDate() {
        final LocalDate result = this.periodStartDate;
        return result;
    }

    /**
     * 期間終了日を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param periodEndDate
     *                      期間終了日
     */
    @Override
    public void setPeriodEndDate(final LocalDate periodEndDate) {
        this.periodEndDate = periodEndDate;
    }

    /**
     * 期間終了日を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 期間終了日
     */
    @Override
    public LocalDate getPeriodEndDate() {
        final LocalDate result = this.periodEndDate;
        return result;
    }

    /**
     * 始値を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param op
     *           始値
     */
    @Override
    public void setOp(final BigDecimal op) {
        this.op = op;
    }

    /**
     * 始値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 始値
     */
    @Override
    public BigDecimal getOp() {
        final BigDecimal result = this.op;
        return result;
    }

    /**
     * 高値を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param hp
     *           高値
     */
    @Override
    public void setHp(final BigDecimal hp) {
        this.hp = hp;
    }

    /**
     * 高値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 高値
     */
    @Override
    public BigDecimal getHp() {
        final BigDecimal result = this.hp;
        return result;
    }

    /**
     * 安値を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param lp
     *           安値
     */
    @Override
    public void setLp(final BigDecimal lp) {
        this.lp = lp;
    }

    /**
     * 安値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 安値
     */
    @Override
    public BigDecimal getLp() {
        final BigDecimal result = this.lp;
        return result;
    }

    /**
     * 終値を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param cp
     *           終値
     */
    @Override
    public void setCp(final BigDecimal cp) {
        this.cp = cp;
    }

    /**
     * 終値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 終値
     */
    @Override
    public BigDecimal getCp() {
        final BigDecimal result = this.cp;
        return result;
    }

    /**
     * 出来高を設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param volume
     *               出来高
     */
    @Override
    public void setVolume(final long volume) {
        this.volume = volume;
    }

    /**
     * 出来高を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 出来高
     */
    @Override
    public long getVolume() {
        final long result = this.volume;
        return result;
    }

    /**
     * 終値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 終値
     */
    @Override
    public BigDecimal get() {
        final BigDecimal result = this.cp;
        return result;
    }

}
