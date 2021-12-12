package kmg.im.stock.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 投資株式テクニカル指標の種類<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum ImStkTechIndicatorTypes implements Supplier<Long> {

    /* 定義：開始 */

    /** 指定無し */
    NONE("指定無し", -1, ImStkCodeValueTypes.NONE),

    /** 単純移動平均（ＳＭＡ） */
    SMA("単純移動平均（ＳＭＡ）", 1, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** 指数移動平均（ＥＭＡ） */
    EMA("指数移動平均（ＥＭＡ）", 2, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** ＭＡＣＤ */
    MACD("ＭＡＣＤ", 3, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** ＭＣＡＤヒストグラム */
    MCADH("ＭＣＡＤヒストグラム", 4, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** ディレクショナル・システム */
    DS("ディレクショナル・システム", 5, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** ＯＢＶ（オン・バランス・ボリューム） */
    OBV("ＯＢＶ（オン・バランス・ボリューム）", 6, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** アキュミュレーション */
    ACCUMULATION("アキュミュレーション", 7, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** ディストリビューション */
    DISTRIBUTION("ディストリビューション", 8, ImStkCodeValueTypes.TREND_FOLLOW_TYPE),

    /** ストキャスティック */
    DTOCASTER("ストキャスティック", 9, ImStkCodeValueTypes.OSCILLATOR),

    /** ＲＯＣ（スムーズ化された価格変化率） */
    ROC("ＲＯＣ（スムーズ化された価格変化率）", 10, ImStkCodeValueTypes.OSCILLATOR),

    /** モメンタム */
    MOMENTUM("モメンタム", 11, ImStkCodeValueTypes.OSCILLATOR),

    /** ＲＳＩ（相対力指数） */
    RSI("ＲＳＩ（相対力指数）", 12, ImStkCodeValueTypes.OSCILLATOR),

    /** エルダー線 */
    EL("エルダー線", 13, ImStkCodeValueTypes.OSCILLATOR),

    /** 勢力指数 */
    PI("勢力指数", 14, ImStkCodeValueTypes.OSCILLATOR),

    /** ウィリアムズの％Ｒ */
    WMPR("ウィリアムズの％Ｒ", 15, ImStkCodeValueTypes.OSCILLATOR),

    /** コモディティー・チャネル指数 */
    CCI("コモディティー・チャネル指数", 16, ImStkCodeValueTypes.OSCILLATOR),

    /** 新高値―新安値指数 */
    NHNLI("新高値―新安値指数", 17, ImStkCodeValueTypes.CALC_OTHER),

    /** プット―コール比率 */
    PCR("プット―コール比率", 18, ImStkCodeValueTypes.CALC_OTHER),

    /** 強気のコンセンサス */
    BC("強気のコンセンサス", 19, ImStkCodeValueTypes.CALC_OTHER),

    /** ＣｏＴ（コミットメント・オブ・トレーダーズ） */
    COT("ＣｏＴ（コミットメント・オブ・トレーダーズ）", 20, ImStkCodeValueTypes.CALC_OTHER),

    /** 騰落指数 */
    RFI("騰落指数", 21, ImStkCodeValueTypes.CALC_OTHER),

    /** トレーダー指数 */
    TI("トレーダー指数", 22, ImStkCodeValueTypes.CALC_OTHER),

    /** 過去の最安値 */
    LOWEST_PRICE_IN_PAST("過去の最安値", 23, ImStkCodeValueTypes.CALC_OTHER),

    /* 定義：終了 */
    ;

    /** 名称 */
    private String name;

    /** 値 */
    private Long value;

    /** コード値の種類 */
    private ImStkCodeValueTypes codeValueTypes;

    /** 種類のマップ */
    private static final Map<Long, ImStkTechIndicatorTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final ImStkTechIndicatorTypes type : ImStkTechIndicatorTypes.values()) {
            ImStkTechIndicatorTypes.VALUES_MAP.put(type.get(), type);
        }
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param name
     *                       名称
     * @param value
     *                       値
     * @param codeValueTypes
     *                       コード値の種類
     */
    ImStkTechIndicatorTypes(final String name, final long value, final ImStkCodeValueTypes codeValueTypes) {

        this.name = name;
        this.value = value;
        this.codeValueTypes = codeValueTypes;

    }

    /**
     * 値に該当する種類を返す<br>
     * <p>
     * 但し、値が存在しない場合は、指定無し（NONE）を返す。
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param value
     *              値
     * @return 種類。指定無し（NONE）：値が存在しない場合。
     */
    public static ImStkTechIndicatorTypes getEnum(final Long value) {

        ImStkTechIndicatorTypes result = ImStkTechIndicatorTypes.VALUES_MAP.get(value);
        if (result == null) {
            result = NONE;
            return result;
        }
        return result;
    }

    /**
     * 初期値の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 初期値
     */
    public static ImStkTechIndicatorTypes getInitValue() {

        final ImStkTechIndicatorTypes result = NONE;
        return result;

    }

    /**
     * デフォルトの種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return デフォルト値
     */
    public static ImStkTechIndicatorTypes getDefault() {

        final ImStkTechIndicatorTypes result = NONE;
        return result;
    }

    /**
     * 値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 値
     */
    @Override
    public String toString() {
        final String result = this.value.toString();
        return result;
    }

    /**
     * 名称を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 名称
     */
    public String getName() {
        final String result = this.name;
        return result;
    }

    /**
     * 値を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 値
     */
    public Long getValue() {
        final long result = this.value;
        return result;
    }

    /**
     * コード値の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return コード値の種類
     */
    public ImStkCodeValueTypes getImStkCodeValueTypes() {
        final ImStkCodeValueTypes result = this.codeValueTypes;
        return result;
    }

    /**
     * 種類の値<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 種類の値
     */
    @Override
    public Long get() {
        final long result = this.value;
        return result;
    }

}
