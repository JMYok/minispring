package com.minis;

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
public class ClassPathXmlApplicationContext {
    private List<BeanDefinition> beanDefinitions = new ArrayList<>();
    private Map<String,Object> singletons = new HashMap<>();

    public ClassPathXmlApplicationContext(String fileName){
        this.readXml(fileName);
        this.instanceBeans();
    }

    /**
     * 读取xml中的信息
     * @param fileName
     */
    private void readXml(String fileName){
        SAXReader saxReader = new SAXReader();
        try {
            URL xmlPath = this.getClass().getClassLoader().getResource(fileName);
            Document document = saxReader.read(xmlPath);
            Element rootElement = document.getRootElement();
            //对配置文件中每一个<bean>进行处理
            for(Element element: rootElement.elements()){
                //获取bean的基本信息,将xml中的信息封装为对象
                String beanId = element.attributeValue("id");
                String beanClassName = element.attributeValue("class");
                BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
                //存放到统一的beanDefinitions数组中
                beanDefinitions.add(beanDefinition);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用反射创建bean实例，存储在singletons中
     */
    private void instanceBeans(){
        for(BeanDefinition beanDefinition: beanDefinitions){
            try {
                singletons.put(beanDefinition.getId(),Class.forName(beanDefinition.getClassName()).newInstance());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 让外部对象从容器中获取bean实例
     * @param beanName
     * @return
     */
    public Object getBean(String beanName){
        return singletons.get(beanName);
    }
}
