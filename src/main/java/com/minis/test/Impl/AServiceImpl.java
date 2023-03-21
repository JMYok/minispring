package com.minis.test.Impl;

import com.minis.test.AService;

public class AServiceImpl implements AService {
    @Override
    public void sayHello() {
        System.out.println("a service 1 say hello~");
    }
}
