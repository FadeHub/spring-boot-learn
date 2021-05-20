package com.sl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sl.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author shuliangzhao
 * @Title: SysUserMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2021/5/20 15:36
 */
@Repository("sysUserMapper")
public interface SysUserMapper extends BaseMapper<SysUser> {
}
