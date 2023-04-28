package com.example.springbootdemo.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName：InstantiationAwareBeanPostProcessorTest
 * @Description：TODO
 * @Author：pengliu
 * @Date：2023/4/25 18:51
 */
@Component
@Slf4j
public class InstantiationAwareBeanPostProcessorTest implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("jp")){
          log.info("postProcessBeforeInitialization:{}",beanName);
          User user =(User) bean;
            user.setAge(100);
            return user;
        }
        log.info("beanName:{}",beanName);
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if(beanName.equals("jp")){

            User user =(User) bean;
            log.info("postProcessAfterInstantiation:{}",user.getAge());
        }
        return true;
    }
}
