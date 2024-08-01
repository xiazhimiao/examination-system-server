package com.xiazhimiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 @ServletComponentScan：解决过滤器未被扫描的问题
 *
 */
@ServletComponentScan
@SpringBootApplication
public class ExaminationSystemServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExaminationSystemServerApplication.class, args);
    }

}
