package com.bai.xiaohu.service.impl;

import com.bai.xiaohu.pojo.User;
import com.bai.xiaohu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/21 16:30
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int deleteAll(List<String> ids) {
        return 0;
    }
}
