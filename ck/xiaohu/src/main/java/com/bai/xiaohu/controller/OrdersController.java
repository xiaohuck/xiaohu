package com.bai.xiaohu.controller;

import com.bai.xiaohu.pojo.Orders;
import com.bai.xiaohu.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author xiaohu
 * @Date 2020/3/24 12:15
 * @Version 1.0
 * 订单详情
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        PageInfo<Orders> pageInfo = ordersService.findAll(page, size);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
}
