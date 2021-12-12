package com.sl.controller;

import com.sl.recursion.LimitMeshRecursion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @package: com.sl.controller
 * @author: shuliangzhao
 * @description:
 * @date 2021/12/1217:02
 */
@RestController
public class LimitMeshRecursionController {

    @Autowired
    private LimitMeshRecursion limitMeshRecursion;

    /**
     * 递归查询父节点
     * @param node
     * @return
     */
    @RequestMapping("/getParent")
    public List<String> getParentNoList(String node) {
        return limitMeshRecursion.getLimitMeshParentList(node);
    }

    /**
     * 递归查询子节点
     * @param node
     * @return
     */
    @RequestMapping("/getChild")
    public List<String> getChildNoList(String node) {
        return limitMeshRecursion.getLimitMeshChildList(node);
    }
}
