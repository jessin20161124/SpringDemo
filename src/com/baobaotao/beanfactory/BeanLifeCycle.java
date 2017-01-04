package com.baobaotao.beanfactory;

import com.baobaotao.Car;
import com.baobaotao.com.baobaotao.beanfactory.MyInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by gzx on 16-11-10.
 */
public class BeanLifeCycle {
    private static void LifeCycleInBeanFactory(){
        Resource res = new ClassPathResource("com/baobaotao/beanfactory/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
        Car car1 = (Car)bf.getBean("car");
        System.out.println("-----------------bean factory end---1----------");
        car1.setColor("green");
    //    System.out.println(car1);
        Car car2 = (Car)bf.getBean("car");
        System.out.println("-----------------bean factory end---2----------");
        System.out.println("car1 == car2 : " + (car1 == car2));
    //    System.out.println(car2);
        System.out.println(car1 + "\n" + car2);
        ((XmlBeanFactory)bf).destroySingletons();

    }

    public static void main(String[] args){
        LifeCycleInBeanFactory();
    }
}
