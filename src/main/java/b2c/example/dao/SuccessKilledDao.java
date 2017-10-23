package b2c.example.dao;

import b2c.example.domain.SuccessKilled;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 菜小川 on 2017/10/23.
 */
public interface SuccessKilledDao {
    //插入购买明细，可过滤重复（联合主键）
    int insertSuccessKilled(@Param("seckillId")long seckillId, @Param("userPhone")long userPhone);

    //根据id查询SuccessKilled并携带Seckill实体
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId, @Param("userPhone")long userPhone);
}
