package com.minis;

import com.minis.beans.BeanDefinition;
import com.minis.core.BeanFactory;
import com.minis.core.Resource;
import org.dom4j.Element;

/**
 * @author jmy
 * 把已解析的XML内容转换为BeanDefinition对象
 */
public class XmlBeanDefinitionReader {
    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource){
        while (resource.hasNext()){
            Element element = (Element)resource.next();
            String beanId = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanId, beanClassName);
            this.beanFactory.registerBeanDefinition(beanDefinition);
        }
    }

}
