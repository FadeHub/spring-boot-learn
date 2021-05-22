package com.sl.mapper;

import com.sl.entity.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: SysUserMapper
 * @ProjectName SpringSecurityDemo
 * @Description: TODO
 * @date 2021/5/19 15:37
 */
@Repository("sysUserMapper")
public interface SysUserMapper {

    @Select("select * from sys_user where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "com.sl.mapper.RoleMapper.findByUid"))
    })
    public SysUser findUserByName(String userName);

}
