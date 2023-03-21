package com.minis;

import com.minis.context.ClassPathXmlApplicationContext;
import com.minis.exceptions.BeansException;
import com.minis.test.AService;
import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void test1() throws BeansException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        AService aservice = (AService)ctx.getBean("aservice");
        aservice.sayHello();
    }
}
