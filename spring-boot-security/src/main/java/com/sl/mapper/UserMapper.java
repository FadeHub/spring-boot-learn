package com.sl.mapper;

import com.sl.dto.Role;
import com.sl.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: UserMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/31 19:55
 */
@Mapper
public interface UserMapper {

    User loadUserByUserName(String username);
    List<Role> getUserRolesByUid(Integer id);
}
