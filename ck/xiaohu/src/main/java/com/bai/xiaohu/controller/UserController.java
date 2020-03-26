package com.bai.xiaohu.controller;
import com.bai.xiaohu.pojo.User;
import com.bai.xiaohu.service.UserService;
import com.beust.jcommander.Parameter;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,@RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {
        PageInfo<User> pageInfo = userService.findAll(page, size);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:findAll";
    }

    @RequestMapping("/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        userService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        User user = userService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user-edit");
        return mv;
    }
}
