package com.sl.recursion;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sl.entity.LimitMesh;
import com.sl.service.LimitMeshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @package: com.sl.recursion
 * @author: shuliangzhao
 * @description:
 * @date 2021/12/12 16:45
 */
@Service
public class LimitMeshRecursion {

    @Autowired
    private LimitMeshService limitMeshService;

    /**
     * 递归找父节点
     * @param nodeNo
     * @return
     */
    public List<String> getLimitMeshParentList(String nodeNo) {
        List<String> parentList = new ArrayList<>();
        List<LimitMesh> limitMeshList = limitMeshService.getLimitMeshList();
        getParentNodeNo(limitMeshList,nodeNo,parentList);
        return parentList;
    }

    private List<String> getParentNodeNo(List<LimitMesh> limitMeshList,String nodeNo,List<String> parentList) {
        if (!parentList.contains(nodeNo)) {
            parentList.add(nodeNo);
        }
        List<String> parentRecursionList = getParentRecursionList(nodeNo,limitMeshList);
        if (CollectionUtils.isNotEmpty(parentRecursionList)) {
            if (!parentList.containsAll(parentRecursionList)) {
                parentList.addAll(parentRecursionList);
            }
            for (String str:parentRecursionList) {
                List<String> parentNodeNoList = getParentNodeNo(limitMeshList, str, parentList);
                if (!parentList.containsAll(parentNodeNoList)) {
                    parentList.addAll(parentNodeNoList);
                }
            }
        }
        return parentList;
    }

    private List<String> getParentRecursionList(String nodeNo, List<LimitMesh> limitMeshList) {
        return limitMeshList.stream().filter(limitMesh -> limitMesh.getChildNode().equals(nodeNo))
                .map(limitMesh -> limitMesh.getParentNode()).collect(Collectors.toList());
    }


    /**
     * 递归找子节点
     * @param nodeNo
     * @return
     */
    public List<String> getLimitMeshChildList(String nodeNo) {
        List<String> childList = new ArrayList<>();
        List<LimitMesh> limitMeshList = limitMeshService.getLimitMeshList();
        getChildNodeNo(limitMeshList,nodeNo,childList);
        return childList;
    }

    private List<String> getChildNodeNo(List<LimitMesh> limitMeshList, String nodeNo, List<String> childList) {
        if (!childList.contains(nodeNo)) {
            childList.add(nodeNo);
        }
        List<String> childRecursionList = getChildRecursionList(nodeNo,limitMeshList);
        if (CollectionUtils.isNotEmpty(childRecursionList)) {
            if (!childList.containsAll(childRecursionList)) {
                childList.addAll(childRecursionList);
            }
            for (String str:childRecursionList) {
                List<String> childNodeNoList = getChildNodeNo(limitMeshList, str, childList);
                if (!childList.containsAll(childNodeNoList)) {
                    childList.addAll(childNodeNoList);
                }
            }
        }
        return childList;
    }

    private List<String> getChildRecursionList(String nodeNo, List<LimitMesh> limitMeshList) {
        return limitMeshList.stream()
                .filter(limitMesh -> limitMesh.getParentNode().equals(nodeNo))
                .map(limitMesh -> limitMesh.getChildNode()).collect(Collectors.toList());
    }

    /**
     * 递归查询账户层节点
     * @param nodeNo
     * @return
     */
    public List<String> getLimitMeshAcctParentNoList(String nodeNo) {
        List<String> parentList = new ArrayList<>();
        List<LimitMesh> limitMeshList = limitMeshService.getLimitMeshList();
        getAcctParentNodeNo(limitMeshList,nodeNo,parentList);
        return parentList;
    }

    private List<String> getAcctParentNodeNo(List<LimitMesh> limitMeshList, String nodeNo, List<String> parentList) {
        if (!parentList.contains(nodeNo)) {
            parentList.add(nodeNo);
        }
        List<String> parentRecursionList = getAcctParentRecursionList(nodeNo,limitMeshList);
        if (CollectionUtils.isNotEmpty(parentRecursionList)) {
            if (!parentList.containsAll(parentRecursionList)) {
                parentList.addAll(parentRecursionList);
            }
            for (String str:parentRecursionList) {
                List<String> parentNodeNoList = getAcctParentNodeNo(limitMeshList, str, parentList);
                if (!parentList.containsAll(parentNodeNoList)) {
                    parentList.addAll(parentNodeNoList);
                }
            }
        }
        return parentList;
    }

    private List<String> getAcctParentRecursionList(String nodeNo, List<LimitMesh> limitMeshList) {
        return limitMeshList.stream().filter(limitMesh -> limitMesh.getChildNode().equals(nodeNo))
                .filter(limitMesh -> !StringUtils.equals(limitMesh.getParentNode(),"cust"))
                .filter(limitMesh -> !StringUtils.equals(limitMesh.getParentNode(),"custTotal"))
                .map(limitMesh -> limitMesh.getParentNode()).collect(Collectors.toList());
    }
}
