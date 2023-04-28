package com.example.springbootdemo.decorator;

/**
 * @ClassName：Decorator
 * @Description：TODO
 * @Author：pengliu
 * @Date：2022/10/25 11:07
 */
public class Decorator implements House{
    private  House house;
    public Decorator(House houds){
        this.house=houds;
    }
    @Override
    public void output() {
        System.out.println("这是针对房子的前段装饰增强");
        house.output();
        System.out.println("这是针对房子的后段装饰增强");
    }
}
