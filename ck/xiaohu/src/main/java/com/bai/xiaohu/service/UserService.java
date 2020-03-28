package com.bai.xiaohu.service;

import com.bai.xiaohu.pojo.User;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/21 16:19
 * @Version 1.0
 */
public interface UserService {

    PageInfo<User> findAll(Integer page,Integer size);

    User findById(String id);

    int edit(User user);

    int add(User user);

    int delete(String id);

    int deleteAll(@Param("ids") List<String> ids);

    User findName(String name);
}
