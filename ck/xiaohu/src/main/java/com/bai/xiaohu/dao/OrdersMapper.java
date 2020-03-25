package com.bai.xiaohu.dao;

import com.bai.xiaohu.pojo.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/24 10:27
 * @Version 1.0
 */
public interface OrdersMapper {
    List<Orders> findAll();

    int add(Orders orders);

    int edit(Orders orders);

    Orders findById(String id);

    int delete(String id);

    int deleteAll(@Param("ids") List<String> ids);
}
