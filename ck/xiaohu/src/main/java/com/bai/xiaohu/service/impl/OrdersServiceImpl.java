package com.bai.xiaohu.service.impl;

import com.bai.xiaohu.dao.OrdersMapper;
import com.bai.xiaohu.pojo.Orders;
import com.bai.xiaohu.service.OrdersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author xiaohu
 * @Date 2020/3/24 10:30
 * @Version 1.0
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;


    @Override
    public PageInfo<Orders> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Orders> ordersList = ordersMapper.findAll();

        return new PageInfo<Orders> (ordersList);
    }

    @Override
    public int add(Orders orders) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        orders.setId(id);
        return ordersMapper.add(orders);
    }

    @Override
    public int edit(Orders orders) {
        return ordersMapper.edit(orders);
    }

    @Override
    public Orders findById(String id) {
        return ordersMapper.findById(id);
    }

    @Override
    public int delete(String id) {
        return ordersMapper.delete(id);
    }

    @Override
    public int deleteAll(List<String> ids) {
        return ordersMapper.deleteAll(ids);
    }
}
