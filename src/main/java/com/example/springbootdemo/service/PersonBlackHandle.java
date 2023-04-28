package com.example.springbootdemo.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName：PersonBlackHandle
 * @Description：TODO
 * @Author：pengliu
 * @Date：2022/10/19 15:59
 */
@Component
public class PersonBlackHandle extends PersonHandle{
    @Override
    String colorPerson() {
        String ll ="hello black person!!";
        return ll;
    }
}
