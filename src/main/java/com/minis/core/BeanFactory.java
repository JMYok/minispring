package com.minis.core;

import com.minis.beans.BeanDefinition;
import com.minis.exceptions.BeansException;

/**
 * @author jmy
 * 抽象出bean工厂
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object getBean(String beanName) throws BeansException;

    /**
     * 注册BeanDefinition(将Bean加入容器)
     * @param beanDefinition
     */
    void registerBeanDefinition(BeanDefinition beanDefinition);
}
