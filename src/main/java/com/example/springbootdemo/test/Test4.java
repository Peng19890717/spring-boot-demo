package com.example.springbootdemo.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test4 {
    @Value("${spring.profiles.active}")
    String param;

    public String getParam() {

        return param;
    }

    public Test4() {
       System.out.println("!!!!!!!!");
    }
}
