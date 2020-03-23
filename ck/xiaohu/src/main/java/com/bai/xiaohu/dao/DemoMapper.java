package com.bai.xiaohu.dao;

import com.bai.xiaohu.pojo.Demo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/17 14:29
 * @Version 1.0
 */
@Repository
public interface DemoMapper {
    List<Demo> listAll();
}
