package com.sl.service;

import com.sl.entity.SysUser;
import com.sl.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author shuliangzhao
 * @Title: UserService
 * @ProjectName SpringSecurityDemo
 * @Description: TODO
 * @date 2021/5/19 15:11
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserMapper.findUserByName(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        Collection<? extends GrantedAuthority> authorities = sysUser.getAuthorities();

        List<GrantedAuthority> admin = AuthorityUtils.createAuthorityList("admin");
        return new User(sysUser.getUsername(),sysUser.getPassword(),authorities);
    }
}
