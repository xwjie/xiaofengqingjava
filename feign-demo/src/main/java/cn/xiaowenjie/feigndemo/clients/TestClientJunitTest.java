package cn.xiaowenjie.feigndemo.clients;


import cn.xiaowenjie.feigndemo.beans.ResultBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClientJunitTest {
    @Autowired
    TestClient testClient;

    @Test
    public void simpleTest(){
        ResultBean<String> test = testClient.test();
        Assert.assertEquals(test, new ResultBean<>("ok"));
    }
}
