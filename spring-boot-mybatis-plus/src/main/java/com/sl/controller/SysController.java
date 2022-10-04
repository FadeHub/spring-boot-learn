package com.sl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sl.domain.TDmCust;
import com.sl.entity.SysUser;
import com.sl.mapper.SysUserMapper;
import com.sl.mapper.TDmCustMapper;
import com.sl.mapper.TDmCustMapperExt;
import com.sl.service.SysUserService;
import com.sl.service.TDmCustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private TDmCustService tDmCustService;

    @Autowired
    private TDmCustMapper tDmCustMapper;

    @Autowired
    private TDmCustMapperExt tDmCustMapperExt;

    @GetMapping("/getSysUserByName")
    public void  getSysUserByName() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","长伞");
//        try{
            SysUser sysUser = sysUserMapper.selectOne(queryWrapper);
            System.out.println(sysUser);
//        } catch (DataAccessException e) {
//            System.out.println("就是我");
//            e.printStackTrace();
//        }
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
        //for (int i=1;i<100;i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUsername("长伞");
            sysUser.setPassword("123456");
            sysUsers.add(sysUser);
        //}
        sysUserService.save(sysUser);
    }

    @GetMapping("/insertBatch")
    public void insertBatch() {
        System.out.println("批量插入开始");
        Long start = System.currentTimeMillis();
        List<TDmCust> tDmCusts = new ArrayList<>();
        for (int i = 1; i< 1000001;i++) {
            TDmCust tDmCust = new TDmCust();
            tDmCust.setId(Long.valueOf(i));
            tDmCust.setBalBmp("张三" + i);
            tDmCust.setAbSource("张三" + i);
            tDmCust.setBank("张三" + i);
            tDmCust.setBalCmpfee("张三" + i);
            tDmCust.setBlockCode("张三" + i);
            tDmCust.setBank("张三" + i);
            tDmCust.setBlockDay("张三" + i);
            tDmCust.setBmwYn("张三" + i);
            tDmCust.setBusiLevel("张三" + i);
            tDmCust.setBusiPhone("张三" + i);
            tDmCust.setBusiServ("张三" + i);
            tDmCust.setCaPcnt("张三" + i);
            tDmCust.setClassCode("张三" + i);
            tDmCust.setClassNbr("张三" + i);
            tDmCust.setClyn("张三" + i);
            tDmCust.setCollEnd("张三" + i);
            tDmCust.setCompDuty("张三" + i);
            tDmCust.setCollExp("张三" + i);
            tDmCust.setCompName("张三" + i);
            tDmCust.setCompName2("张三" + i);
            tDmCust.setConBegdt("张三" + i);
            tDmCust.setConEnddt("张三" + i);
            tDmCust.setCrappldate("张三" + i);
            tDmCust.setCrexpReq("张三" + i);
            tDmCust.setCrFlag("张三" + i);
            tDmCust.setCustSts("张三" + i);
            tDmCust.setCustrSeg("张三" + i);
            tDmCust.setCusplit("张三" + i);
            tDmCust.setCrsucsdate("张三" + i);
            tDmCust.setCredLimit("张三" + i);
            tDmCust.setCredRst("张三" + i);
            tDmCust.setIdDte("张三" + i);
            tDmCust.setMailCode("张三" + i);
            tDmCust.setHmtelArea("张三" + i);
            tDmCust.setHomePhone("张三" + i);
            tDmCust.setGender("张三" + i);
            tDmCust.setCreateTime(new Date());
            tDmCust.setUpdateTime(new Date());
            tDmCusts.add(tDmCust);
            if (i%1000==0) {
                tDmCustService.saveBatch(tDmCusts,1000);
                tDmCusts.clear();
            }
        }
        tDmCustService.saveBatch(tDmCusts);
        System.out.println("批量插入结束");
        System.out.println("批量插入耗时统计：" + (System.currentTimeMillis() - start) / 1000);
    }

    @RequestMapping("/getTdmCust/{id}")
    public TDmCust getTDmCust(@PathVariable("id") Long id) {
        TDmCust tDmCust = tDmCustMapper.selectByPrimaryKey(id);
        return tDmCust;
    }

    @RequestMapping("/getTdmCustRedis/{id}")
    public TDmCust getTDmCustRedis(@PathVariable("id") Long id) {
        TDmCust tDmCust = tDmCustMapperExt.selectByPrimaryKey(id);
        return tDmCust;
    }

}
