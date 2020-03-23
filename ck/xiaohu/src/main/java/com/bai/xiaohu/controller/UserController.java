package com.bai.xiaohu.controller;
import com.bai.xiaohu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * @Author xiaohu
 * @Date 2020/3/21 16:11
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("syslog-list");
        return mv;
    }


}
