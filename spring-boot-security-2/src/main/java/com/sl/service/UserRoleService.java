package com.sl.service;

import com.sl.dao.UserRoleMapper;
import com.sl.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: UserRoleService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:36
 */
@Service
public class UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<UserRole> seletListByUserId(Integer uid) {
        return userRoleMapper.listByUseId(uid);
    }
}
