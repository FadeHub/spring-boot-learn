package com.sl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sl.entity.LimitMesh;
import com.sl.mapper.LimitMeshMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.sl
 * @author: shuliangzhao
 * @description:
 * @date 2021/12/1215:51
 */
@Service
public class LimitMeshService {

    @Autowired
    private LimitMeshMapper limitMeshMapper;

    public List<LimitMesh> getLimitMeshList() {
        return limitMeshMapper.selectList(new QueryWrapper<>());
    }

}
