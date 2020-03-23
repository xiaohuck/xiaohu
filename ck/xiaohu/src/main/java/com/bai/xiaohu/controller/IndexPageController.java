package com.bai.xiaohu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author xiaohu
 * @Date 2020/3/20 16:09
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class IndexPageController {


    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("login");//设置对应JSP的模板文件
        return mv;
    }
}
