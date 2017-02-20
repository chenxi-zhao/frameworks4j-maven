package shd.test;

import com.alibaba.fastjson.JSON;
import com.chenxi.spring4hibernate.dao.UserDao;
import com.chenxi.spring4hibernate.entity.User;
import com.chenxi.spring4hibernate.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by zhaochx1 on 2016/12/1.
 *
 * @author zhaochx1
 */
// 告诉spring怎样执行
@RunWith(SpringJUnit4ClassRunner.class)
//  标明是web应用测试
//可以不填，默认此目录
@WebAppConfiguration(value = "src/main/webapp")
// 配置文件地址
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-hibernate.xml", "classpath:spring-mvc.xml"})
public class UtilTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Before
    public void before() {
        System.out.println("准备测试！");
    }

    @After
    public void after() {
        System.out.println("测试结束!");
    }

    @Test
    public void get() {
        User user = userDao.get("from User", User.class);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void add(){
        User user = new User();
        user.setId(99L);
        user.setName("wodemingzi");
        user.setPassword("!@#$%^&");
        userService.addUser(user);
    }


}
