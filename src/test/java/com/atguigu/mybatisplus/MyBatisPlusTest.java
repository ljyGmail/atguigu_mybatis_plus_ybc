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
        // 查询所有的用户信息
        // SELECT id,name,age,email FROM user
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

    @Test
    public void testUpdate() {
        // 修改用户信息
        // UPDATE user SET name=?, email=? WHERE id=?
        User user = new User(4L, "홍길동", null, "hgd@mybatis.com");
        int result = userMapper.updateById(user);
        System.out.println("result: " + result);
    }

    @Test
    public void testSelectById() {
        // 通过id查询用户信息
        // SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1L);
        System.out.println("user: " + user);
    }

    @Test
    public void testSelectBatchIds() {
        // 根据多个id查询多个用户信息
        // SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap() {
        // 根据map集合中的条件查询用户信息
        // SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Jack");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
}
