package b2c.example.exception;

/**
 * Created by 菜小川 on 2017/10/23.
 */

/**
 * 重复秒杀异常，运行期异常，不需要手动try。catch
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
