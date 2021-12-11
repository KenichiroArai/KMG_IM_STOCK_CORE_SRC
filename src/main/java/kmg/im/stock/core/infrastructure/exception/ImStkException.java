package kmg.im.stock.core.infrastructure.exception;

import kmg.im.stock.core.infrastructure.types.ImStkLogMessageTypes;

/**
 * 投資株式例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class ImStkException extends Exception {

    /** デフォルトシリアルバージョンＵＩＤ */
    private static final long serialVersionUID = 1L;

    /** 資株式ログメッセージの種類 */
    private final ImStkLogMessageTypes logMsgTypes;

    /** ログメッセージの引数 */
    private final Object[] logMsgArgs;

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
    public ImStkException(final String errMsg, final ImStkLogMessageTypes logMsgTypes, final Object[] logMsgArgs) {
        super(errMsg);
        this.logMsgTypes = logMsgTypes;
        this.logMsgArgs = logMsgArgs;
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
    public ImStkException(final String errMsg, final ImStkLogMessageTypes logMsgTypes) {
        this(errMsg, logMsgTypes, (Object[]) null);
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
    public ImStkException(final String errMsg, final ImStkLogMessageTypes logMsgTypes, final Throwable cause) {
        super(errMsg, cause);
        this.logMsgTypes = logMsgTypes;
        this.logMsgArgs = null;
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
    public ImStkException(final String errMsg, final ImStkLogMessageTypes logMsgTypes, final Object[] logMsgArgs,
        final Throwable cause) {
        super(errMsg, cause);
        this.logMsgTypes = logMsgTypes;
        this.logMsgArgs = logMsgArgs;
    }

    /**
     * 資株式ログメッセージの種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return 資株式ログメッセージの種類
     */
    public ImStkLogMessageTypes getLogMsgTypes() {
        final ImStkLogMessageTypes result = this.logMsgTypes;
        return result;
    }

    /**
     * ログメッセージの引数を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return ログメッセージの引数
     */
    public Object[] getLogMsgArgs() {
        final Object[] result = this.logMsgArgs;
        return result;
    }

}
