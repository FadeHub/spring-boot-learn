package com.sl.service;

import com.sl.dto.User;
import com.sl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author shuliangzhao
 * @Title: UserService
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/31 19:55
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在！");
        }
        user.setRoles(userMapper.getUserRolesByUid(user.getId()));
        return user;
    }
}
