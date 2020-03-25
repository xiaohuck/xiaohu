package com.bai.xiaohu.service;

import com.bai.xiaohu.pojo.Product;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {

    PageInfo<Product> findAll(Integer page,Integer size);

    int add(Product product);

    int edit(Product product);

    Product findById(String id);

    int delete(String id);

    int deleteAll(@Param("ids") List<String> ids);
}
