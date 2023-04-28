package com.example.springbootdemo.decorator;

/**
 * @ClassName：LiuPeng
 * @Description：TODO
 * @Author：pengliu
 * @Date：2022/10/25 10:46
 */
public class LiuPengHouse implements House{
    @Override
    public void output() {
        System.out.println("liu peng de house!!");
    }
}
