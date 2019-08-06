package com.sl.security;

import com.sl.entity.Permission;
import com.sl.entity.User;
import com.sl.service.PermissionService;
import com.sl.service.RoleService;
import com.sl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 自定义对 hasPermission() 方法的处理
 * @author shuliangzhao
 * @Title: CustomPermissionEvaluator
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/6 19:31
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object permission) {
        // 获得loadUserByUsername()中注入的角色
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        // 遍历用户所有角色
        for (GrantedAuthority authority:authorities) {
            String roleName = authority.getAuthority();
            Integer rId = roleService.selectByName(roleName).getId();
            // 得到角色所有的权限
            List<Permission> permissions = permissionService.selectListById(rId);

            // permissions
            for (Permission per:permissions) {
                //获取权限集
                List<String> permissions1 = per.getPermissions();
                if (targetUrl.equals(per.getUrl()) && permissions1.contains(permission)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
