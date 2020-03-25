package com.bai.xiaohu.controller;

import com.bai.xiaohu.pojo.Product;
import com.bai.xiaohu.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "5") Integer size){
        ModelAndView mv = new ModelAndView();
        PageInfo<Product> pageInfo = productService.findAll(page, size);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/add")
    public String add(Product product){
        productService.add(product);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        productService.delete(id);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Product product = productService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("product",product);
        mv.setViewName("product-add");
        return mv;
    }
}
