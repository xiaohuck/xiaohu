package com.bai.xiaohu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author xiaohu
 * @Date 2020/3/23 14:19
 * @Version 1.0
 */
@Controller
@RequestMapping("/pb")
public class ConfigController {
    @RequestMapping("/pb")
    public ModelAndView pb(){
        ModelAndView mv = new ModelAndView("product-add");
        return mv;
    }
}
