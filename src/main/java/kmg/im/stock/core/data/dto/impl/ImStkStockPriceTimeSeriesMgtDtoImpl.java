package kmg.im.stock.core.data.dto.impl;

import java.util.ArrayList;
import java.util.List;

import kmg.core.infrastructure.utils.ListUtils;
import kmg.im.stock.core.data.dto.ImStkStockPriceTimeSeriesDto;
import kmg.im.stock.core.data.dto.ImStkStockPriceTimeSeriesMgtDto;

/**
 * 投資株式株価時系列管理ＤＴＯ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkStockPriceTimeSeriesMgtDtoImpl implements ImStkStockPriceTimeSeriesMgtDto {

    /** 投資株式株価時系列ＤＴＯのリスト */
    private final List<ImStkStockPriceTimeSeriesDto> dataList;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkStockPriceTimeSeriesMgtDtoImpl() {
        this.dataList = new ArrayList<>();
    }

    /**
     * 投資株式株価時系列ＤＴＯのリストをクリアする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Override
    public void clearDataList() {
        this.dataList.clear();
    }

    /**
     * 投資株式株価時系列ＤＴＯのリストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    @Override
    public boolean isDataListEmpty() {
        boolean result = true;

        if (ListUtils.isEmpty(this.dataList)) {
            return result;
        }

        result = false;
        return result;
    }

    /**
     * 投資株式株価時系列ＤＴＯのリストが空ではないか<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空ではない、false：空
     */
    @Override
    public boolean isDataListNotEmpty() {
        final boolean result = !this.isDataListEmpty();
        return result;
    }

    /**
     * 株価時系列を追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             株価時系列
     */
    @Override
    public void addData(final ImStkStockPriceTimeSeriesDto data) {
        this.dataList.add(data);
    }

    /**
     * 投資株式株価時系列ＤＴＯのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加 投資株式株価時系列ＤＴＯのリスト
     */
    @Override
    public void addAllData(final List<ImStkStockPriceTimeSeriesDto> addData) {
        if (ListUtils.isEmpty(addData)) {
            return;
        }

        this.dataList.addAll(addData);
    }

    /**
     * 投資株式株価時系列ＤＴＯのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価時系列ＤＴＯのリスト
     */
    @Override
    public List<ImStkStockPriceTimeSeriesDto> getDataList() {
        final List<ImStkStockPriceTimeSeriesDto> result = this.dataList;
        return result;
    }
}
