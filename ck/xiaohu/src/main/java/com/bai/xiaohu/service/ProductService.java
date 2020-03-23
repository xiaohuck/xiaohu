package com.bai.xiaohu.service;

import com.bai.xiaohu.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductService {
    List<Product>  findAll();

    int add(Product product);

    int edit(Product product);

    Product findById(String id);

    int delete(String id);

    int deleteAll(@Param("ids") List<String> ids);
}
