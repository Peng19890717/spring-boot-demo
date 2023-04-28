package com.example.springbootdemo.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName：PersonWhiteHandle
 * @Description：TODO
 * @Author：pengliu
 * @Date：2022/10/19 16:01
 */
@Component
public class PersonWhiteHandle extends PersonHandle{
    @Override
    String colorPerson() {
        String ll="hello white person!!";
        return ll;
    }
}
