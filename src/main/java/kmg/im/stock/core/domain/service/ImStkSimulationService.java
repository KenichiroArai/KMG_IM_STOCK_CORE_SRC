package kmg.im.stock.core.domain.service;

import kmg.im.stock.core.infrastructure.exception.ImStkDomainException;

/**
 * 投資株式シミュレーションサービスインタフェース<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public interface ImStkSimulationService {

    /**
     * 全ての銘柄をシミュレーションする<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    void simulate() throws ImStkDomainException;

    /**
     * シミュレーションする<br>
     * <p>
     * 指定した株コードのシミュレーションする
     * </p>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param stockCode
     *                  株コード
     * @throws ImStkDomainException
     *                              投資株式ドメイン例外
     */
    void simulate(final long stockCode) throws ImStkDomainException;

}
