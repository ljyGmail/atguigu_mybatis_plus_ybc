package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void testDeleteById() {
        // 通过id删除用户信息
        // DELETE FROM user WHERE id=?
        int result = userMapper.deleteById(1945047573270102018L);
        System.out.println("result: " + result);
    }

    @Test
    public void testDeleteByMap() {
        // 根据map中key指定的条件来删除用户信息
        // DELETE FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zs");
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result: " + result);
    }

    @Test
    public void testDeleteBatchIds() {
        // 批量删除多个用户信息
        // DELETE FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result: " + result);
    }
}
