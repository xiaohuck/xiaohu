package com.bai.xiaohu.service.impl;

import com.bai.xiaohu.dao.UserMapper;
import com.bai.xiaohu.pojo.User;
import com.bai.xiaohu.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Author xiaohu
 * @Date 2020/3/21 16:30
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<User> userList = userMapper.findAll();
        return new PageInfo<User> (userList);
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public int edit(User user) {
        return userMapper.edit(user);
    }

    @Override
    public int add(User user) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        user.setId(id);
        return userMapper.add(user);
    }

    @Override
    public int delete(String id) {
        return userMapper.delete(id);
    }

    @Override
    public int deleteAll(List<String> ids) {
        return userMapper.deleteAll(ids);
    }
}
