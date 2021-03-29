package org.example.mybatis.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhaohaoren
 */
@MapperScan("org.example.mybatis.boot.mapper")
@SpringBootApplication
public class MybatisSourceSamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisSourceSamplesApplication.class, args);
    }

}
