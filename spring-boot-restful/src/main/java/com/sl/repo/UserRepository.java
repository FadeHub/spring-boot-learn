package com.sl.repo;

import com.sl.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author shuliangzhao
 * @Title: UserRepository
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/7/28 17:38
 */
//@CrossOrigin 支持跨域
@RepositoryRestResource(path = "us" ,collectionResourceRel = "us",itemResourceRel = "b")
public interface UserRepository extends JpaRepository<User,Integer> {

    @RestResource(path = "name",rel = "name")
    User findByNameEquals(@Param("name")String name);
}
