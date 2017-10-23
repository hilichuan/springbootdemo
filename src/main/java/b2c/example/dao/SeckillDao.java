package b2c.example.dao;

import b2c.example.domain.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by 菜小川 on 2017/10/23.
 */
public interface SeckillDao {

    //减库存
    int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    //根据id查询商品信息
    Seckill queryById(long seckillId);

    //根据偏移量查询秒杀商品列表
    List<Seckill> queryAll(@Param("offset")int offset, @Param("limit")int limit);
}
