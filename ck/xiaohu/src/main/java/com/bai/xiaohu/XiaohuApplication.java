package com.bai.xiaohu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bai.xiaohu.dao")
public class XiaohuApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaohuApplication.class, args);
    }

}
