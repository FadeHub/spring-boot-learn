package com.sl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sl.entity.SysUser;
import com.sl.mapper.SysUserMapper;
import com.sl.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/getSysUserByName")
    public void  getSysUserByName() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","xiaoming");
        SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
        System.out.println(sysUser);
    }

    @GetMapping("/getPage")
    public void  getPage() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        Page<SysUser> page = new Page();
        page.setCurrent(2);
        page.setSize(10);
        Page<SysUser> page1 = sysUserMapper.selectPage(page, queryWrapper);
        List<SysUser> records = page1.getRecords();
        System.out.println(records);
    }

    @GetMapping("/insert")
    public void insert() {
        List<SysUser> sysUsers = new ArrayList<>();
        for (int i=1;i<100;i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUsername("长伞");
            sysUser.setPassword("123456");
            sysUsers.add(sysUser);
        }
        sysUserService.saveBatch(sysUsers);
    }
}
