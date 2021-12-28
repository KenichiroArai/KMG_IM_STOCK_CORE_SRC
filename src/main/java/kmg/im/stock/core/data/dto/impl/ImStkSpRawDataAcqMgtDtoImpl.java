package kmg.im.stock.core.data.dto.impl;

import java.util.ArrayList;
import java.util.List;

import kmg.core.infrastructure.utils.KmgListUtils;
import kmg.im.stock.core.data.dto.ImStkSpRawDataAcqDto;
import kmg.im.stock.core.data.dto.ImStkSpRawDataAcqMgtDto;

/**
 * 投資株式株価生データ取得管理ＤＴＯ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSpRawDataAcqMgtDtoImpl implements ImStkSpRawDataAcqMgtDto {

    /** 投資株式株価生データ取得ＤＴＯのリスト */
    private final List<ImStkSpRawDataAcqDto> dataList;

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    public ImStkSpRawDataAcqMgtDtoImpl() {
        this.dataList = new ArrayList<>();
    }

    /**
     * 投資株式株価生データ取得ＤＴＯのリストをクリアする<br>
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
     * 投資株式株価生データ取得ＤＴＯのリストが空か<br>
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
     * 投資株式株価生データ取得ＤＴＯのリストが空ではないか<br>
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
     * 株価生データ取得を追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param data
     *             株価生データ取得
     */
    @Override
    public void addData(final ImStkSpRawDataAcqDto data) {
        this.dataList.add(data);
    }

    /**
     * 投資株式株価生データ取得ＤＴＯのリストを全て追加する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param addData
     *                追加投資株式株価生データ取得ＤＴＯのリスト
     */
    @Override
    public void addAllData(final List<ImStkSpRawDataAcqDto> addData) {
        if (KmgListUtils.isEmpty(addData)) {
            return;
        }

        this.dataList.addAll(addData);
    }

    /**
     * 投資株式株価生データ取得ＤＴＯのリストを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 投資株式株価生データ取得ＤＴＯのリスト
     */
    @Override
    public List<ImStkSpRawDataAcqDto> getDataList() {
        final List<ImStkSpRawDataAcqDto> result = this.dataList;
        return result;
    }
}
