package b2c.example.exception;

/**
 * Created by 菜小川 on 2017/10/23.
 */

/**
 * 秒杀业务相关异常
 */
public class SeckillException extends RuntimeException {
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
