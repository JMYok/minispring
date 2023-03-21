package com.minis;

import com.minis.test.AService;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aservice = (AService)ctx.getBean("aservice");
        aservice.sayHello();
    }
}
