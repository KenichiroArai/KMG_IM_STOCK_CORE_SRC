package kmg.im.stock.core.infrastructure.resolver;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

import kmg.im.stock.core.infrastructure.types.ImStkMessageTypes;

/**
 * 投資株式メッセージリゾルバ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
@Component
public class ImStkMessageResolver {

    /** メッセージソース */
    private final MessageSource messageSource;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageSource
     *                      メッセージソース
     */
    public ImStkMessageResolver(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * メッセージを返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param code
     *             メッセージコード
     * @param args
     *             メッセージ引数
     * @return メッセージ
     */
    public String getMessage(final ImStkMessageTypes code, final Object... args) {

        String result = null;

        Object[] argsArrays = args;
        if (argsArrays == null) {
            argsArrays = new Object[0];
        }

        try {
            result = this.messageSource.getMessage(code.get(), argsArrays, Locale.getDefault());
        } catch (final NoSuchMessageException e) {
            // TODO KenichiroArai 2021/05/13 例外処理
            System.err.println(code.get());
            e.printStackTrace();
            result = code.get();
            return result;
        }

        return result;
    }

}
