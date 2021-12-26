package kmg.im.stock.core.domain.logic.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import kmg.core.infrastructure.type.KmgDecimal;
import kmg.im.stock.core.domain.model.ImStkPowerIndexCalcModel;
import kmg.im.stock.core.domain.model.ImStkStockPriceTimeSeriesModel;
import kmg.im.stock.core.domain.model.impl.ImStkStockPriceTimeSeriesModelImpl;

/**
 * 投資株式指勢力指数ロジックテスト<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
@Transactional
public class ImStkPowerIndexLogicImplTests {

    /** テスト対象 */
    @Autowired
    private ImStkPowerIndexLogicImpl testTarget;

    /**
     * テスト００１_計算する_正常００１_パターン１<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    @Test
    @SuppressWarnings("nls")
    public void テスト００１_計算する_正常００１_パターン１() {

        /* 期待値 */
        final int expectedDataSize = 50;
        final List<BigDecimal> expectedDataList = Arrays.asList(KmgDecimal.RESULT_ZERO, new BigDecimal("266472270.000"),
            new BigDecimal("-491712480.000"), new BigDecimal("250939430.000"), new BigDecimal("-136680125.000"),
            new BigDecimal("0.000"), new BigDecimal("9685207.000"), new BigDecimal("-4065005.000"),
            new BigDecimal("-5457600.000"), new BigDecimal("730800.000"), new BigDecimal("-4131000.000"),
            new BigDecimal("-941400.000"), new BigDecimal("-4482000.000"), new BigDecimal("-7315200.000"),
            new BigDecimal("-3062400.000"), new BigDecimal("2925000.000"), new BigDecimal("4980000.000"),
            new BigDecimal("-1654800.000"), new BigDecimal("3384000.000"), new BigDecimal("-134400.000"),
            new BigDecimal("0.000"), new BigDecimal("0.000"), new BigDecimal("-3692400.000"),
            new BigDecimal("-732000.000"), new BigDecimal("178200.000"), new BigDecimal("63600.000"),
            new BigDecimal("111600.000"), new BigDecimal("-342000.000"), new BigDecimal("34800.000"),
            new BigDecimal("-378000.000"), new BigDecimal("-218400.000"), new BigDecimal("48000.000"),
            new BigDecimal("-632400.000"), new BigDecimal("0.000"), new BigDecimal("-336000.000"),
            new BigDecimal("-8067600.000"), new BigDecimal("-315000.000"), new BigDecimal("-459000.000"),
            new BigDecimal("127200.000"), new BigDecimal("-950400.000"), new BigDecimal("-858000.000"),
            new BigDecimal("-2565000.000"), new BigDecimal("1638000.000"), new BigDecimal("1877400.000"),
            new BigDecimal("1764000.000"), new BigDecimal("1692000.000"), new BigDecimal("1180800.000"),
            new BigDecimal("-1332000.000"), new BigDecimal("1333200.000"), new BigDecimal("307200.000"));

        /* 準備 */
        final List<ImStkPowerIndexCalcModel> dataList = new ArrayList<>();
        final ImStkStockPriceTimeSeriesModel add01 = new ImStkStockPriceTimeSeriesModelImpl();
        add01.setCp(new BigDecimal("512"));
        add01.setVolume(6301206L);
        dataList.add(add01);
        final ImStkStockPriceTimeSeriesModel add02 = new ImStkStockPriceTimeSeriesModelImpl();
        add02.setCp(new BigDecimal("542"));
        add02.setVolume(8882409L);
        dataList.add(add02);
        final ImStkStockPriceTimeSeriesModel add03 = new ImStkStockPriceTimeSeriesModelImpl();
        add03.setCp(new BigDecimal("462"));
        add03.setVolume(6146406L);
        dataList.add(add03);
        final ImStkStockPriceTimeSeriesModel add04 = new ImStkStockPriceTimeSeriesModelImpl();
        add04.setCp(new BigDecimal("508"));
        add04.setVolume(5455205L);
        dataList.add(add04);
        final ImStkStockPriceTimeSeriesModel add05 = new ImStkStockPriceTimeSeriesModelImpl();
        add05.setCp(new BigDecimal("483"));
        add05.setVolume(5467205L);
        dataList.add(add05);
        final ImStkStockPriceTimeSeriesModel add06 = new ImStkStockPriceTimeSeriesModelImpl();
        add06.setCp(new BigDecimal("483"));
        add06.setVolume(1546802L);
        dataList.add(add06);
        final ImStkStockPriceTimeSeriesModel add07 = new ImStkStockPriceTimeSeriesModelImpl();
        add07.setCp(new BigDecimal("490"));
        add07.setVolume(1383601L);
        dataList.add(add07);
        final ImStkStockPriceTimeSeriesModel add08 = new ImStkStockPriceTimeSeriesModelImpl();
        add08.setCp(new BigDecimal("485"));
        add08.setVolume(813001L);
        dataList.add(add08);
        final ImStkStockPriceTimeSeriesModel add09 = new ImStkStockPriceTimeSeriesModelImpl();
        add09.setCp(new BigDecimal("473"));
        add09.setVolume(454800L);
        dataList.add(add09);
        final ImStkStockPriceTimeSeriesModel add10 = new ImStkStockPriceTimeSeriesModelImpl();
        add10.setCp(new BigDecimal("475"));
        add10.setVolume(365400L);
        dataList.add(add10);
        final ImStkStockPriceTimeSeriesModel add11 = new ImStkStockPriceTimeSeriesModelImpl();
        add11.setCp(new BigDecimal("458"));
        add11.setVolume(243000L);
        dataList.add(add11);
        final ImStkStockPriceTimeSeriesModel add12 = new ImStkStockPriceTimeSeriesModelImpl();
        add12.setCp(new BigDecimal("455"));
        add12.setVolume(313800L);
        dataList.add(add12);
        final ImStkStockPriceTimeSeriesModel add13 = new ImStkStockPriceTimeSeriesModelImpl();
        add13.setCp(new BigDecimal("425"));
        add13.setVolume(149400L);
        dataList.add(add13);
        final ImStkStockPriceTimeSeriesModel add14 = new ImStkStockPriceTimeSeriesModelImpl();
        add14.setCp(new BigDecimal("393"));
        add14.setVolume(228600L);
        dataList.add(add14);
        final ImStkStockPriceTimeSeriesModel add15 = new ImStkStockPriceTimeSeriesModelImpl();
        add15.setCp(new BigDecimal("377"));
        add15.setVolume(191400L);
        dataList.add(add15);
        final ImStkStockPriceTimeSeriesModel add16 = new ImStkStockPriceTimeSeriesModelImpl();
        add16.setCp(new BigDecimal("402"));
        add16.setVolume(117000L);
        dataList.add(add16);
        final ImStkStockPriceTimeSeriesModel add17 = new ImStkStockPriceTimeSeriesModelImpl();
        add17.setCp(new BigDecimal("427"));
        add17.setVolume(199200L);
        dataList.add(add17);
        final ImStkStockPriceTimeSeriesModel add18 = new ImStkStockPriceTimeSeriesModelImpl();
        add18.setCp(new BigDecimal("413"));
        add18.setVolume(118200L);
        dataList.add(add18);
        final ImStkStockPriceTimeSeriesModel add19 = new ImStkStockPriceTimeSeriesModelImpl();
        add19.setCp(new BigDecimal("443"));
        add19.setVolume(112800L);
        dataList.add(add19);
        final ImStkStockPriceTimeSeriesModel add20 = new ImStkStockPriceTimeSeriesModelImpl();
        add20.setCp(new BigDecimal("442"));
        add20.setVolume(134400L);
        dataList.add(add20);
        final ImStkStockPriceTimeSeriesModel add21 = new ImStkStockPriceTimeSeriesModelImpl();
        add21.setCp(new BigDecimal("442"));
        add21.setVolume(96600L);
        dataList.add(add21);
        final ImStkStockPriceTimeSeriesModel add22 = new ImStkStockPriceTimeSeriesModelImpl();
        add22.setCp(new BigDecimal("442"));
        add22.setVolume(106200L);
        dataList.add(add22);
        final ImStkStockPriceTimeSeriesModel add23 = new ImStkStockPriceTimeSeriesModelImpl();
        add23.setCp(new BigDecimal("425"));
        add23.setVolume(217200L);
        dataList.add(add23);
        final ImStkStockPriceTimeSeriesModel add24 = new ImStkStockPriceTimeSeriesModelImpl();
        add24.setCp(new BigDecimal("415"));
        add24.setVolume(73200L);
        dataList.add(add24);
        final ImStkStockPriceTimeSeriesModel add25 = new ImStkStockPriceTimeSeriesModelImpl();
        add25.setCp(new BigDecimal("418"));
        add25.setVolume(59400L);
        dataList.add(add25);
        final ImStkStockPriceTimeSeriesModel add26 = new ImStkStockPriceTimeSeriesModelImpl();
        add26.setCp(new BigDecimal("420"));
        add26.setVolume(31800L);
        dataList.add(add26);
        final ImStkStockPriceTimeSeriesModel add27 = new ImStkStockPriceTimeSeriesModelImpl();
        add27.setCp(new BigDecimal("423"));
        add27.setVolume(37200L);
        dataList.add(add27);
        final ImStkStockPriceTimeSeriesModel add28 = new ImStkStockPriceTimeSeriesModelImpl();
        add28.setCp(new BigDecimal("413"));
        add28.setVolume(34200L);
        dataList.add(add28);
        final ImStkStockPriceTimeSeriesModel add29 = new ImStkStockPriceTimeSeriesModelImpl();
        add29.setCp(new BigDecimal("415"));
        add29.setVolume(17400L);
        dataList.add(add29);
        final ImStkStockPriceTimeSeriesModel add30 = new ImStkStockPriceTimeSeriesModelImpl();
        add30.setCp(new BigDecimal("405"));
        add30.setVolume(37800L);
        dataList.add(add30);
        final ImStkStockPriceTimeSeriesModel add31 = new ImStkStockPriceTimeSeriesModelImpl();
        add31.setCp(new BigDecimal("398"));
        add31.setVolume(31200L);
        dataList.add(add31);
        final ImStkStockPriceTimeSeriesModel add32 = new ImStkStockPriceTimeSeriesModelImpl();
        add32.setCp(new BigDecimal("402"));
        add32.setVolume(12000L);
        dataList.add(add32);
        final ImStkStockPriceTimeSeriesModel add33 = new ImStkStockPriceTimeSeriesModelImpl();
        add33.setCp(new BigDecimal("385"));
        add33.setVolume(37200L);
        dataList.add(add33);
        final ImStkStockPriceTimeSeriesModel add34 = new ImStkStockPriceTimeSeriesModelImpl();
        add34.setCp(new BigDecimal("385"));
        add34.setVolume(40200L);
        dataList.add(add34);
        final ImStkStockPriceTimeSeriesModel add35 = new ImStkStockPriceTimeSeriesModelImpl();
        add35.setCp(new BigDecimal("377"));
        add35.setVolume(42000L);
        dataList.add(add35);
        final ImStkStockPriceTimeSeriesModel add36 = new ImStkStockPriceTimeSeriesModelImpl();
        add36.setCp(new BigDecimal("350"));
        add36.setVolume(298800L);
        dataList.add(add36);
        final ImStkStockPriceTimeSeriesModel add37 = new ImStkStockPriceTimeSeriesModelImpl();
        add37.setCp(new BigDecimal("347"));
        add37.setVolume(105000L);
        dataList.add(add37);
        final ImStkStockPriceTimeSeriesModel add38 = new ImStkStockPriceTimeSeriesModelImpl();
        add38.setCp(new BigDecimal("338"));
        add38.setVolume(51000L);
        dataList.add(add38);
        final ImStkStockPriceTimeSeriesModel add39 = new ImStkStockPriceTimeSeriesModelImpl();
        add39.setCp(new BigDecimal("340"));
        add39.setVolume(63600L);
        dataList.add(add39);
        final ImStkStockPriceTimeSeriesModel add40 = new ImStkStockPriceTimeSeriesModelImpl();
        add40.setCp(new BigDecimal("318"));
        add40.setVolume(43200L);
        dataList.add(add40);
        final ImStkStockPriceTimeSeriesModel add41 = new ImStkStockPriceTimeSeriesModelImpl();
        add41.setCp(new BigDecimal("307"));
        add41.setVolume(78000L);
        dataList.add(add41);
        final ImStkStockPriceTimeSeriesModel add42 = new ImStkStockPriceTimeSeriesModelImpl();
        add42.setCp(new BigDecimal("282"));
        add42.setVolume(102600L);
        dataList.add(add42);
        final ImStkStockPriceTimeSeriesModel add43 = new ImStkStockPriceTimeSeriesModelImpl();
        add43.setCp(new BigDecimal("297"));
        add43.setVolume(109200L);
        dataList.add(add43);
        final ImStkStockPriceTimeSeriesModel add44 = new ImStkStockPriceTimeSeriesModelImpl();
        add44.setCp(new BigDecimal("318"));
        add44.setVolume(89400L);
        dataList.add(add44);
        final ImStkStockPriceTimeSeriesModel add45 = new ImStkStockPriceTimeSeriesModelImpl();
        add45.setCp(new BigDecimal("333"));
        add45.setVolume(117600L);
        dataList.add(add45);
        final ImStkStockPriceTimeSeriesModel add46 = new ImStkStockPriceTimeSeriesModelImpl();
        add46.setCp(new BigDecimal("348"));
        add46.setVolume(112800L);
        dataList.add(add46);
        final ImStkStockPriceTimeSeriesModel add47 = new ImStkStockPriceTimeSeriesModelImpl();
        add47.setCp(new BigDecimal("360"));
        add47.setVolume(98400L);
        dataList.add(add47);
        final ImStkStockPriceTimeSeriesModel add48 = new ImStkStockPriceTimeSeriesModelImpl();
        add48.setCp(new BigDecimal("350"));
        add48.setVolume(133200L);
        dataList.add(add48);
        final ImStkStockPriceTimeSeriesModel add49 = new ImStkStockPriceTimeSeriesModelImpl();
        add49.setCp(new BigDecimal("372"));
        add49.setVolume(60600L);
        dataList.add(add49);
        final ImStkStockPriceTimeSeriesModel add50 = new ImStkStockPriceTimeSeriesModelImpl();
        add50.setCp(new BigDecimal("380"));
        add50.setVolume(38400L);
        dataList.add(add50);

        /* テスト対象を呼び出す */
        final List<Supplier<BigDecimal>> actualDataListTmp = this.testTarget.calc(dataList);
        List<BigDecimal> actualDataList = actualDataListTmp.stream().map(Supplier::get).collect(Collectors.toList());
        final int actualDataSize = actualDataList.size();
        // 結果を有効桁数を期待値に合わせる
        actualDataList = actualDataList.stream().map(KmgDecimal::setResultScale).collect(Collectors.toList());

        /* 期待値と比較 */
        Assertions.assertNotNull(actualDataList);
        Assertions.assertEquals(expectedDataSize, actualDataSize);
        Assertions.assertEquals(expectedDataList, actualDataList);

    }

}
