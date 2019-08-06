package com.sl.service;

import com.sl.dao.RoleMapper;
import com.sl.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: RoleService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/3 14:35
 */
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public Role selectById(Integer id) {
        return roleMapper.selectById(id);
    }

    public Role selectByName(String name) {
        return roleMapper.selectByName(name);
    }
}
