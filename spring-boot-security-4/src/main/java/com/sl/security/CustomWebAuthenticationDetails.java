package com.sl.security;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取用户登录时携带的额外信息
 * @author shuliangzhao
 * @Title: CustomWebAuthenticationDetails
 * @ProjectName spring-boot-learn
 * @Description: TODO
 * @date 2019/8/4 17:14
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {

    private final String verifyCode;
    
    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        // verifyCode为页面中验证码的name
        verifyCode = request.getParameter("verifyCode");
    }

    public String getVerifyCode() {
        return this.verifyCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("; VerifyCode: ").append(this.getVerifyCode());
        return sb.toString();
    }
}
