package com.bai.xiaohu.controller;
import com.bai.xiaohu.utlis.Json;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author xiaohu
 * @Date 2020/3/20 16:09
 * @Version 1.0
 */
@RestController
@RequestMapping("/")
public class Login {


    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("login");//设置对应JSP的模板文件
        return mv;
    }

    @RequestMapping("/login")
    public Json login(@RequestParam("username") String username, @RequestParam("password") String password){

        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return Json.succ().data("未知账户");
        } catch (IncorrectCredentialsException ice) {
            return Json.succ().data("密码不正确");
        } catch (LockedAccountException lae) {
            return Json.succ().data("账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            return Json.succ().data("用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            return Json.succ().data("用户名或密码不正确");
        }
        if (subject.isAuthenticated()) {
            return Json.succ().data("登录成功");
        } else {
            token.clear();
            return Json.succ().data("登录失败");
        }
    }

    @RequestMapping("/logout")
    public ModelAndView logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new ModelAndView("login");
    }
}
