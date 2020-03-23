package com.bai.xiaohu.service.impl;

import com.bai.xiaohu.dao.DemoMapper;
import com.bai.xiaohu.pojo.Demo;
import com.bai.xiaohu.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xiaohu
 * @Date 2020/3/17 14:07
 * @Version 1.0
 */
@Service
public class DemoServiceimpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;
    @Override
    public List<Demo> listAll() {
        return demoMapper.listAll();
    }
}
