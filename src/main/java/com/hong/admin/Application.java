package com.hong.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author yk
 * @version 1.0.0
 */
@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
