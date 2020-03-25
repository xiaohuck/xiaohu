package com.bai.xiaohu.service;

import com.bai.xiaohu.pojo.Orders;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/24 10:29
 * @Version 1.0
 */
public interface OrdersService {

    PageInfo<Orders> findAll(Integer page,Integer size);

    int add(Orders orders);

    int edit(Orders orders);

    Orders findById(String id);

    int delete(String id);

    int deleteAll(@Param("ids") List<String> ids);
}
