package com.sl.mapper;


import com.sl.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author shuliangzhao
 * @Title: BookMapper
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/23 23:03
 */
public interface BookMapper {

    List<User> getUser();

    int insert(User user);

    void updateBatch(List<User> userList);
}
