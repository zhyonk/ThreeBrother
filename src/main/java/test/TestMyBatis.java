package test;

import com.example.dao.WechatDao;
import com.example.service.impl.WechatServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
//@ContextConfiguration(locations = {"classpath:spring/spring-mybatis.xml"})

public class TestMyBatis {
    // 加载spring配置文件
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration({"classpath:spring/spring-mybatis.xml"})
    public static class IUserDaoTest {

        @Autowired
        private WechatDao wechatDao;

        @Test
        public void testSelectUser() throws Exception {
            long now = new Date().getTime();
            Timestamp nowTime = new java.sql.Timestamp(now);
            int result = wechatDao.saveOAuthToken("asd",132, nowTime);
            System.out.println(result);
        }
    }
}