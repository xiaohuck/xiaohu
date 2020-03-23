package com.bai.xiaohu.dao;

import com.bai.xiaohu.pojo.User;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/21 16:40
 * @Version 1.0
 */
public interface UserMapper {

    int add(User user);

    int update(User user);

    int delete(String id);

    int deleteAll(List<String> ids);

    User findById(String id);

    List<User> listAll();
}
