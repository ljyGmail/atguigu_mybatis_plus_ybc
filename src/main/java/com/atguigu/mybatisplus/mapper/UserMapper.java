package com.atguigu.mybatisplus.mapper;

import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Map;

/**
 * ClassName: UserMapper
 * Package: com.atguigu.mybatisplus.mapper
 * Description:
 *
 * @Author: ljy
 * @Create: 2025. 7. 15. 오후 4:47
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id查询用户信息为map集合
     *
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);
}
