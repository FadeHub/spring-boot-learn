package com.sl.mapper;

import com.sl.entity.SysRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: RoleMapper
 * @ProjectName SpringSecurityDemo
 * @Description: TODO
 * @date 2021/5/19 15:53
 */
@Repository("roleMapper")
public interface RoleMapper {

    @Select("SELECT r.id, r.role_name roleName, r.role_desc roleDesc " +
            "FROM sys_role r, sys_user_role ur " +
            "WHERE r.id=ur.rid AND ur.uid=#{uid}")
    public List<SysRole> findByUid(Integer uid);
}
