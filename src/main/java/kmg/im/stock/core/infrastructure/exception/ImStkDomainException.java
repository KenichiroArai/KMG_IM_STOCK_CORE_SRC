package kmg.im.stock.core.infrastructure.exception;

import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;

/**
 * 投資株式ドメイン例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkDomainException extends ImStkException {

    /** デフォルトシリアルバージョンＵＩＤ */
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param errMsg
     *                    エラーメッセージ
     * @param logMsgTypes
     *                    資株式ログメッセージの種類
     * @param logMsgArgs
     *                    ログメッセージの引数
     */
    public ImStkDomainException(final String errMsg, final ImStkLogMessageTypes logMsgTypes,
        final Object[] logMsgArgs) {
        super(errMsg, logMsgTypes, logMsgArgs);
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param errMsg
     *                    エラーメッセージ
     * @param logMsgTypes
     *                    資株式ログメッセージの種類
     */
    public ImStkDomainException(final String errMsg, final ImStkLogMessageTypes logMsgTypes) {
        super(errMsg, logMsgTypes);
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param errMsg
     *                    エラーメッセージ
     * @param logMsgTypes
     *                    資株式ログメッセージの種類
     * @param cause
     *                    原因
     */
    public ImStkDomainException(final String errMsg, final ImStkLogMessageTypes logMsgTypes, final Throwable cause) {
        super(errMsg, logMsgTypes, cause);
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param errMsg
     *                    エラーメッセージ
     * @param logMsgTypes
     *                    資株式ログメッセージの種類
     * @param logMsgArgs
     *                    ログメッセージの引数
     * @param cause
     *                    原因
     */
    public ImStkDomainException(final String errMsg, final ImStkLogMessageTypes logMsgTypes, final Object[] logMsgArgs,
        final Throwable cause) {
        super(errMsg, logMsgTypes, logMsgArgs, cause);
    }

}
