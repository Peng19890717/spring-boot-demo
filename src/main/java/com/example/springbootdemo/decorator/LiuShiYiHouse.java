package com.example.springbootdemo.decorator;

/**
 * @ClassName：LiuShiYiHouse
 * @Description：TODO
 * @Author：pengliu
 * @Date：2022/10/25 11:02
 */
public class LiuShiYiHouse implements House{
    @Override
    public void output() {
        System.out.println("Liu Shi Yi de House");
    }
}
