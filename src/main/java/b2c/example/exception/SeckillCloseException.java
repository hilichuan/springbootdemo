package b2c.example.exception;

/**
 * Created by 菜小川 on 2017/10/23.
 */
/**
 * 秒杀关闭异常（时间到了，库存结束），运行期
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
