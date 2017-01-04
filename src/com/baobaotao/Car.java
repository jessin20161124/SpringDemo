package com.baobaotao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/**
 * Created by gzx on 16-11-10.
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;
    public void setBeanFactory(BeanFactory beanFactory)throws BeansException{
        System.out.println("call beanFactoryAware.setBeanFactory : " + beanFactory);
        this.beanFactory = beanFactory;
    }

    public void setBeanName(String beanName){
        this.beanName = beanName;
        System.out.println("call setBeanName beanNameWare : " + beanName);
    }

    public void afterPropertiesSet(){
        System.out.println("call initializing afterPropertiesSet");
    }

    public void destroy(){
        System.out.println("call DisposableBean destroy");
    }

    public void myInit(){
        System.out.println("call init-method myInit");
        this.maxSpeed = 240;
    }

    public void myDestroy(){
        System.out.println("destroy-method, mydestroy");
    }
    public Car(){
        System.out.println("constructor of Car");
    }
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("setBrand");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("set color");
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        System.out.println("set max speed");
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }
}
