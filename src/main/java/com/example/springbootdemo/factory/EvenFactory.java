package com.example.springbootdemo.factory;

import com.example.springbootdemo.service.PersonHandle;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName：EvenFactory
 * @Description：TODO
 * @Author：pengliu
 * @Date：2022/10/19 15:42
 */
@Component
public class EvenFactory {
    @Resource
    List<PersonHandle> list;

    public PersonHandle getEventHandler(String code) {
        list.forEach(x->{
            System.out.println("name:"+x.getClass().getName());
        });
        Optional<PersonHandle> optional = list.stream().filter(baseEventHandler -> baseEventHandler.getClass().getName().equals(code)).findFirst();
        return optional.get();
    }
}
