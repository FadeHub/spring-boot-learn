package com.sl.dao;

import com.sl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author shuliangzhao
 * @Title: UserMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:20
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectById(Integer id);

    @Select("SELECT * FROM user WHERE username = #{name}")
    User selectByName(String name);
}
