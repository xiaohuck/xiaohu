package com.bai.xiaohu.service.impl;

import com.bai.xiaohu.dao.ProductMapper;
import com.bai.xiaohu.pojo.Product;
import com.bai.xiaohu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> findAll() {

        return productMapper.findAll();

    }

    @Override
    public int add(Product product) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        product.setId(id);
        return productMapper.add(product);
    }

    @Override
    public int edit(Product product) {
        return productMapper.edit(product);
    }

    @Override
    public Product findById(String id) {
        return productMapper.findById(id);
    }

    @Override
    public int delete(String id) {
        return productMapper.delete(id);
    }

    @Override
    public int deleteAll(List<String> ids) {
        return productMapper.deleteAll(ids);
    }
}
