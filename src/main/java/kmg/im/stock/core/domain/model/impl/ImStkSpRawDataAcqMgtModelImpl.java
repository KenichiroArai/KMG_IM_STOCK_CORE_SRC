package kmg.im.stock.core.domain.model.impl;

import java.util.ArrayList;
import java.util.List;

import kmg.core.infrastructure.utils.KmgListUtils;
import kmg.im.stock.core.domain.model.ImStkSpRawDataAcqMgtModel;
import kmg.im.stock.core.domain.model.ImStkSpRawDataAcqModel;

/**
 * 投資株式株価生データ取得管理モデル<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSpRawDataAcqMgtModelImpl implements ImStkSpRawDataAcqMgtModel {

    /** 株価銘柄コード */
    private long stockBrandCode;

    /** 投資株式株価生データ取得モデルのリスト */
    private final List<ImStkSpRawDataAcqModel> dataList;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkSpRawDataAcqMgtModelImpl() {
        this.dataList = new ArrayList<>();
    }

    /**
     * 株価銘柄コードを設定する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockBrandCode
     *                       株価銘柄コード
     */
    @Override
    public void setStockBrandCode(final long stockBrandCode) {
        this.stockBrandCode = stockBrandCode;
    }

    /**
     * 株価銘柄コードを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 株価銘柄コード
     */
    @Override
    public long getStockBrandCode() {
        final long result = this.stockBrandCode;
        return result;
    }

    /**
     * 投資株式株価生データ取得モデルのリストをクリアする<br>
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
     * 投資株式株価生データ取得モデルのリストが空か<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：空、false：空ではない
     */
    @Override
    public boolean isDataListEmpty() {
        boolean result = true;

        if (KmgListUtils.isEmpty(this.dataList)) {
            return result;
        }

        result = false;
        return result;
    }

    /**
     * 投資株式株価生データ取得モデルのリストが空ではないか<br>
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
     * 投資株式株価生データ取得モデルを追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             投資株式株価生データ取得モデル
     */
    @Override
    public void addData(final ImStkSpRawDataAcqModel data) {
        this.dataList.add(data);
    }

    /**
     * 投資株式株価生データ取得モデルのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価生データ取得モデルのリスト
     */
    @Override
    public void addAllData(final List<ImStkSpRawDataAcqModel> addData) {
        if (KmgListUtils.isEmpty(addData)) {
            return;
        }

        this.dataList.addAll(addData);
    }

    /**
     * 投資株式株価生データ取得モデルのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価生データ取得モデルのリスト
     */
    @Override
    public List<ImStkSpRawDataAcqModel> getDataList() {
        final List<ImStkSpRawDataAcqModel> result = this.dataList;
        return result;
    }

}
