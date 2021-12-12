package kmg.im.stock.core.infrastructure.types;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 投資株式株価計算値の種類の種類<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SuppressWarnings("nls")
public enum ImStkStockPriceCalcValueTypeTypes implements Supplier<Long> {

    /* 定義：開始 */

    /** 指定無し */
    NONE("指定無し", -1, ImStkTechIndicatorTypes.NONE),

    /** ＭＣＡＤライン */
    MCADL("ＭＣＡＤライン", 1, ImStkTechIndicatorTypes.MACD),

    /** ＭＣＡＤシグナル */
    MCADS("ＭＣＡＤシグナル", 2, ImStkTechIndicatorTypes.MACD),

    /** ＭＣＡＤヒストグラム */
    MCADH("ＭＣＡＤヒストグラム", 3, ImStkTechIndicatorTypes.MCADH),

    /** 勢力指数 */
    PI("勢力指数", 4, ImStkTechIndicatorTypes.PI),

    /** 勢力指数２ＥＭＡ */
    PI2EMA("勢力指数２ＥＭＡ", 5, ImStkTechIndicatorTypes.PI),

    /** 勢力指数１３ＥＭＡ */
    PI13EMA("勢力指数１３ＥＭＡ", 6, ImStkTechIndicatorTypes.PI),

    /** 過去３期間の最安値 */
    LOWEST_PRICE_IN_LAST3_PERIODS("過去３期間の最安値", 7, ImStkTechIndicatorTypes.LOWEST_PRICE_IN_PAST),

    /* 定義：終了 */
    ;

    /** 名称 */
    private String name;

    /** 値 */
    private Long value;

    /** テクニカル指標の種類 */
    private ImStkTechIndicatorTypes techIndicatorTypes;

    /** 種類のマップ */
    private static final Map<Long, ImStkStockPriceCalcValueTypeTypes> VALUES_MAP = new HashMap<>();

    static {

        /* 種類のマップにプット */
        for (final ImStkStockPriceCalcValueTypeTypes type : ImStkStockPriceCalcValueTypeTypes.values()) {
            ImStkStockPriceCalcValueTypeTypes.VALUES_MAP.put(type.get(), type);
        }
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param name
     *                           名称
     * @param value
     *                           値
     * @param techIndicatorTypes
     *                           テクニカル指標の種類
     */
    ImStkStockPriceCalcValueTypeTypes(final String name, final long value,
        final ImStkTechIndicatorTypes techIndicatorTypes) {

        this.name = name;
        this.value = value;
        this.techIndicatorTypes = techIndicatorTypes;

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
    public static ImStkStockPriceCalcValueTypeTypes getEnum(final Long value) {

        ImStkStockPriceCalcValueTypeTypes result = ImStkStockPriceCalcValueTypeTypes.VALUES_MAP.get(value);
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
    public static ImStkStockPriceCalcValueTypeTypes getInitValue() {

        final ImStkStockPriceCalcValueTypeTypes result = NONE;
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
    public static ImStkStockPriceCalcValueTypeTypes getDefault() {

        final ImStkStockPriceCalcValueTypeTypes result = NONE;
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
     * テクニカル指標の種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return テクニカル指標の種類
     */
    public ImStkTechIndicatorTypes getImStkTechIndicatorTypes() {
        final ImStkTechIndicatorTypes result = this.techIndicatorTypes;
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
