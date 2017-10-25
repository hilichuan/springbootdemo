package b2c.example.service.Impl;

import b2c.example.dao.SeckillDao;
import b2c.example.dao.SuccessKilledDao;
import b2c.example.domain.Seckill;
import b2c.example.domain.SuccessKilled;
import b2c.example.dto.Exposer;
import b2c.example.dto.SeckillExecution;
import b2c.example.enums.SeckillStatEnum;
import b2c.example.exception.RepeatKillException;
import b2c.example.exception.SeckillCloseException;
import b2c.example.exception.SeckillException;
import b2c.example.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;


/**
 * Created by 菜小川 on 2017/10/24.
 */
@Service
public class SeckillServiceImpl implements SeckillService{
    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    private final String slat="ewewesdfsdfs";
    //slf4j包不要导入错了，导入org.slf4j
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {

        Seckill seckill = seckillDao.queryById(seckillId);
        //id不存在，不是秒杀对象
        if (seckill == null)
            return new Exposer(false, seckillId);

        Date endTime = seckill.getEndTime();
        Date startTime = seckill.getStartTime();
        Date nowTime = new Date();
        //getTime()返回的是毫秒单位的long数据
        //一般时间以1970-01-01 00:00:00为参考点
        //不在秒杀时间内
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime())
            return new Exposer(false, seckillId, nowTime.getTime(), seckill.getStartTime().getTime(), seckill.getEndTime().getTime());

        //复杂一下url，防止直接被猜到
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);

    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

    @Override
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        //秒杀地址被篡改
        if(md5==null||!md5.equals(getMD5(seckillId)))
            throw new SeckillException("seckill data repeat");

        Date nowTime=new Date();
        //减库存
        try {
            int updateCount=seckillDao.reduceNumber(seckillId,nowTime);
            //库存没了或者不在秒杀时间内
            if(updateCount<=0)
                throw new SeckillCloseException("sechill is closed");
            else {
                //记录购买明细
                int insertCount=successKilledDao.insertSuccessKilled(seckillId,userPhone);
                if(insertCount<=0)
                    //重复秒杀，联合主键+ignore
                    throw new RepeatKillException("success repeated");
                    else {
                        //秒杀成功
                    SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
                    //数据字典一般用常量，现在用枚举.stat和statinfo用枚举实现
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successKilled);
                }
            }
        } catch (SeckillCloseException e) {
            e.printStackTrace();
        } catch (RepeatKillException e) {
            e.printStackTrace();
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("seckill inner error"+e.getMessage());
        }
        return null;
    }
}
