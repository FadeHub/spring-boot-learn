package com.sl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author shuliangzhao
 * @Title: SysRole
 * @ProjectName SpringSecurityDemo
 * @Description: TODO
 * @date 2021/5/19 15:33
 */
@Data
public class SysRole implements GrantedAuthority {

    private Integer id;
    private String roleName;
    private String roleDesc;

    @JsonIgnore
    @Override
    public String getAuthority() {
        return roleName;
    }
}
