package b2c.example.service;

import b2c.example.SpringbootDemoApplication;
import b2c.example.domain.Seckill;
import b2c.example.dto.Exposer;
import b2c.example.dto.SeckillExecution;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 菜小川 on 2017/10/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
@WebAppConfiguration
public class SeckillServiceTest {

    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list=seckillService.getSeckillList();
        logger.info("list={}"+list);
    }

    @Test
    public void getById() throws Exception {
        long id =1000;
        Seckill seckill=seckillService.getById(id);
        logger.info("seckill={}"+seckill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id=1000;
        Exposer exposer=seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        long id=1000;
        long phone=13212341234L;
        String md5="fbb5b6763b713942115d12768718b234";
        SeckillExecution execution=seckillService.executeSeckill(id,phone,md5);
        logger.info("excution="+execution);
    }

}