package kmg.im.stock.core.domain.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import kmg.im.stock.core.domain.logic.ImStkEmaLogic;
import kmg.im.stock.core.domain.service.ImStkEmaService;

/**
 * 投資株式指数移動平均サービス<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Service
@Scope("prototype")
public class ImStkEmaServiceImpl implements ImStkEmaService {

    /** 投資株式投資株式指数移動平均ロジック */
    private final ImStkEmaLogic imStkEmaLogic;

    /** データリスト */
    private final List<Supplier<BigDecimal>> dataList;

    /** 計算日数 */
    private int calcDays;

    /** 計算結果のリスト */
    private final List<Supplier<BigDecimal>> clacResultList;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param imStkEmaLogic
     *                      投資株式投資株式指数移動平均ロジック
     */
    public ImStkEmaServiceImpl(final ImStkEmaLogic imStkEmaLogic) {
        this.imStkEmaLogic = imStkEmaLogic;
        this.dataList = new ArrayList<>();
        this.clacResultList = new ArrayList<>();
    }

    /**
     * 初期化する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param dataList
     *                 データリスト
     * @param calcDays
     *                 計算日数
     */
    @Override
    @SuppressWarnings("hiding")
    public void initialize(final List<Supplier<BigDecimal>> dataList, final int calcDays) {

        this.dataList.clear();

        this.dataList.addAll(dataList);
        this.calcDays = calcDays;
    }

    /**
     * データリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return データリスト
     */
    @Override
    public List<Supplier<BigDecimal>> getDataList() {
        final List<Supplier<BigDecimal>> result = this.dataList;
        return result;
    }

    /**
     * 計算日数を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 計算日数
     */
    @Override
    public int getCalcDays() {
        final int result = this.calcDays;
        return result;
    }

    /**
     * 計算結果のリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 計算結果のリスト
     */
    @Override
    public List<Supplier<BigDecimal>> getClacResultList() {
        final List<Supplier<BigDecimal>> result = this.clacResultList;
        return result;
    }

    /**
     * 計算する<br>
     * <p>
     * データリストを計算日数で計算し結果を返す。
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Override
    public void calc() {
        this.clacResultList.clear();
        final List<Supplier<BigDecimal>> tmpList = this.imStkEmaLogic.calc(this.dataList, this.calcDays);
        this.clacResultList.addAll(tmpList);
    }
}
