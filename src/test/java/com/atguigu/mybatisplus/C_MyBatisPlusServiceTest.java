package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
