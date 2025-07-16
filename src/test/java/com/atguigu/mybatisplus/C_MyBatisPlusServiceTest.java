package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.pojo.User;
import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: C_MyBatisPlusServiceTest
 * Package: com.atguigu.mybatisplus
 * Description:
 *
 * @Author: ljy
 * @Create: 2025. 7. 16. 오후 2:52
 * @Version 1.0
 */
@SpringBootTest
public class C_MyBatisPlusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {
        // 查询总记录数
        // SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("count: " + count);
    }

    @Test
    public void testInsertBatch() {
        // 批量添加
        // 单个INSERT语句循环执行10次
        // INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        List<User> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            User user = new User(null, "ybc" + i, 20 + i, null);
            list.add(user);
        }
        boolean result = userService.saveBatch(list);
        System.out.println("result: " + result);
    }
}
