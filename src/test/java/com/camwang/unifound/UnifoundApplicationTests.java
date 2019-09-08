package com.camwang.unifound;

import com.camwang.unifound.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnifoundApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test() {
        try {
            User user = new User();
            user.setNick("王灿");
            mongoTemplate.save(user, "user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
