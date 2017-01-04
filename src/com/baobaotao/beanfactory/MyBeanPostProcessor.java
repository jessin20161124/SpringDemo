package com.baobaotao.beanfactory;

import com.baobaotao.Car;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by gzx on 16-11-10.
 */
public class MyBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getColor() == null){
                System.out.println("beanPostProcessor call postProcessBeforeInitialization color set black ");
                car.setColor("blcak");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(beanName.equals("car")){
            Car car = (Car)bean;
            if(car.getMaxSpeed() > 200){
                System.out.println("beanPostProcessor call postProcessAfterInitialization color set max speed");
                car.setMaxSpeed(200);
         //       System.out.println("---post process : " + bean);
            }
        }
        return bean;
    }
}
