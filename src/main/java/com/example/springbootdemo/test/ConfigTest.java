package com.example.springbootdemo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @ClassName： ConfigTest
 * @Description：TODO
 * @Author：pengliu
 * @Date：2023/4/25 18:44
 */
@Component
public class ConfigTest {

   @Bean("jp")
   public User initUser(){
       User user =new User();
       user.setName("liup");
       user.setAge(1);
       return user;
   }
}
