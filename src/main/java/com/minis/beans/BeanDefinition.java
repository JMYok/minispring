package com.minis.beans;

import lombok.Data;

/**
 * @author jmy
 * Bean定义类
 */
@Data
public class BeanDefinition {
    private String id;
    private String className;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }
}
