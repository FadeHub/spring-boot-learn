package com.sl.service;

import com.sl.dao.PermissionMapper;
import com.sl.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: PermissionService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/6 19:27
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> selectListById(Integer id) {
         return permissionMapper.selectListById(id);
    }
}
