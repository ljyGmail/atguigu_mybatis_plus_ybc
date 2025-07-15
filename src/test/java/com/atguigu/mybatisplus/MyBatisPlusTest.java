package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * ClassName: MyBatisPlusTest
 * Package: com.atguigu.mybatisplus
 * Description:
 *
 * @Author: ljy
 * @Create: 2025. 7. 15. 오후 4:50
 * @Version 1.0
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        // 实现新增用户信息
        // INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User(null, "이영애", 25, "yylee@mybatis.com");
        int result = userMapper.insert(user);
        System.out.println("result: " + result);
        System.out.println("id: " + user.getId());
    }
}
