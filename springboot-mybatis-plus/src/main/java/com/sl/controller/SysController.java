package com.sl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sl.entity.SysUser;
import com.sl.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuliangzhao
 * @Title: SysController
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 15:45
 */
@RestController
public class SysController {

    @Autowired
    private SysUserMapper sysUserMapper;

    @GetMapping("/getSysUserByName")
    public void  getSysUserByName() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","xiaoming");
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        System.out.println(sysUser);
    }
}
