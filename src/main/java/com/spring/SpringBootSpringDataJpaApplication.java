package com.spring;

import com.spring.service.MyFirstService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootSpringDataJpaApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(SpringBootSpringDataJpaApplication.class, args);

        MyFirstService myFirstService = ctx.getBean(MyFirstService.class);
        System.out.println(myFirstService.tellAStory());
        System.out.println(myFirstService.getJavaVersion());
        System.out.println(myFirstService.getOsName());
        System.out.println(myFirstService.readProp());
    }

}
