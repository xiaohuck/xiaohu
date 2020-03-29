package com.bai.xiaohu.config;

import com.bai.xiaohu.pojo.User;
import com.bai.xiaohu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        System.out.println("-------身份认证方法--------");
        Session session = SecurityUtils.getSubject().getSession();
        String userName = (String) authenticationToken.getPrincipal();
        String userPassword = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        User user = userService.findName(userName);
        String password = user.getPassword();
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } /*else if (!userPassword.equals(password )) {
            throw new AccountException("密码不正确");
        }*/
        session.setAttribute("user",user);
        return new SimpleAuthenticationInfo(userName, password,getName());

    }
}
