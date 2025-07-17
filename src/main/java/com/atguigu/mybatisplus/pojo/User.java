package com.atguigu.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: User
 * Package: com.atguigu.mybatisplus.pojo
 * Description:
 *
 * @Author: ljy
 * @Create: 2025. 7. 15. 오후 4:42
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// 设置实体类所对应的表名
// @TableName("t_user")
public class User {
    // 将属性所对应的字段指定为主键
    @TableId
    private Long uid;
    private String name;
    private Integer age;
    private String email;
}
