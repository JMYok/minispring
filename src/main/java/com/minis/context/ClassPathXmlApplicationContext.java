package com.minis.context;

import com.minis.ClassPathXmlResource;
import com.minis.SimpleBeanFactory;
import com.minis.XmlBeanDefinitionReader;
import com.minis.beans.BeanDefinition;
import com.minis.core.BeanFactory;
import com.minis.core.Resource;
import com.minis.exceptions.BeansException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jmy
 * 解析xml的类
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    private BeanFactory beanFactory;
    public ClassPathXmlApplicationContext(String fileName){
        //1.根据文件名将xml文件解析为document对象
        Resource resource = new ClassPathXmlResource(fileName);
        //2.实例化bean容器
        BeanFactory simpleBeanFactory = new SimpleBeanFactory();
        //3.将document对象构建为BeanDefinition加入bean容器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(simpleBeanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = simpleBeanFactory;
    }
    @Override
    public Object getBean(String beanName) throws BeansException {
        return this.beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanDefinition);
    }
}
