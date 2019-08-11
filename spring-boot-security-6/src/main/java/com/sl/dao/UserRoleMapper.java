package com.sl.dao;

import com.sl.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: UserRoleMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:25
 */
@Mapper
public interface UserRoleMapper {

    @Select("SELECT * FROM user_role WHERE uid = #{uid}")
    List<UserRole> listByUseId(Integer uid);
}
