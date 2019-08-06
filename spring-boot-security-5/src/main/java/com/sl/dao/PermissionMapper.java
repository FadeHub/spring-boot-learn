package com.sl.dao;

import com.sl.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: PermissionMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/6 19:26
 */
@Mapper
public interface PermissionMapper {

    @Select("SELECT * FROM permission where role_id = #{id}")
    List<Permission> selectListById(Integer id);
}
