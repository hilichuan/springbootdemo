package b2c.example.dao;

import b2c.example.SpringbootDemoApplication;
import b2c.example.domain.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by 菜小川 on 2017/10/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
@WebAppConfiguration
public class SuccessKilledDaoTest {
    @Autowired
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000;
        long phone = 13812341234L;
        int count=successKilledDao.insertSuccessKilled(id,phone);
        System.out.println("count="+count);


    }

    @Test
    public void queryByIdWithSeckill() throws Exception {

    }

}