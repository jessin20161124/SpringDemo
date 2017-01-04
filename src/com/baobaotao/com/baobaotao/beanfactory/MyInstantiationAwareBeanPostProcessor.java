package com.baobaotao.com.baobaotao.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * Created by gzx on 16-11-10.
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("Instance postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("car".equals(beanName)){
            System.out.println("Instance postProcessAfterInitialization : ");
        }
        return bean;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
       //System.out.println("property values : " + bean);
        if("car".equals(beanName)){
            System.out.println("Instance postProcessPropertyValues");
        }
        return pvs;

    }
}
