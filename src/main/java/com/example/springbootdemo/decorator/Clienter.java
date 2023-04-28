package com.example.springbootdemo.decorator;

/**
 * @ClassName：Clienter
 * @Description：TODO
 * @Author：pengliu
 * @Date：2022/10/25 11:10
 */
public class Clienter {
    public static void main(String[] args) {
        House liupengHouse = new LiuPengHouse();
        House decorator = new Decorator(liupengHouse);
        decorator.output();
    }
}
