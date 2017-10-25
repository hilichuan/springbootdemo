package b2c.example.service;

import b2c.example.domain.Seckill;
import b2c.example.dto.Exposer;
import b2c.example.dto.SeckillExecution;
import b2c.example.exception.RepeatKillException;
import b2c.example.exception.SeckillCloseException;
import b2c.example.exception.SeckillException;

import java.util.List;

/**
 * Created by 菜小川 on 2017/10/23.
 */
public interface SeckillService {

    List<Seckill> getSeckillList();

    Seckill getById(long seckillId);
    /**
     * 秒杀时间到，暴露秒杀结果地址
     * 时间不到，暴露系统时间
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀
     *
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
    throws SeckillException,RepeatKillException,SeckillCloseException;
}
