package com.sl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sl.domain.TDmCust;
import com.sl.mapper.TDmCustMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @package: com.sl.service
 * @author: shuliangzhao
 * @description:
 * @date 2022/6/15 16:37
 */
@Component
public class TDmCustService extends ServiceImpl<TDmCustMapper, TDmCust> {
}
