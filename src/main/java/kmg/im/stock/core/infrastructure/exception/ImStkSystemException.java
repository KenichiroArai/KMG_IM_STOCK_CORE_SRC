package kmg.im.stock.core.infrastructure.exception;

import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;

/**
 * 投資株式システム例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkSystemException extends ImStkException {

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
    public ImStkSystemException(final String errMsg, final ImStkLogMessageTypes logMsgTypes,
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
     * @param logMsgArgs
     *                    ログメッセージの引数
     * @param cause
     *                    原因
     */
    public ImStkSystemException(final String errMsg, final ImStkLogMessageTypes logMsgTypes, final Object[] logMsgArgs,
        final Throwable cause) {
        super(errMsg, logMsgTypes, logMsgArgs, cause);
    }
}
