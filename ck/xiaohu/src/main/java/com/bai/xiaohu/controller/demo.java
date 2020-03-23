package com.bai.xiaohu.controller;

import com.bai.xiaohu.pojo.Demo;
import com.bai.xiaohu.service.DemoService;
import com.bai.xiaohu.utlis.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/17 13:39
 * @Version 1.0
 */
@RestController
@RequestMapping("/demo")
public class demo {

    @Autowired
    private DemoService demoService;
    @PostMapping("/demo")
    public Json demo(){
        return Json.succ().data(demoService.listAll());
    }
}
