package com.sl.dao;

import com.sl.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author shuliangzhao
 * @Title: RoleMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:23
 */
@Mapper
public interface RoleMapper {

    @Select("SELECT * FROM role WHERE id = #{id}")
    Role selectById(Integer id);
}
