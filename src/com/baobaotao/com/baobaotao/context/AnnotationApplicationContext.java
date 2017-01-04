package com.baobaotao.com.baobaotao.context;

import com.baobaotao.Car;
import com.baobaotao.context.Beans;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
/**
 * Created by gzx on 16-11-10.
 */
public class AnnotationApplicationContext {
    public static void main(String[] args){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
        System.out.println(car.getBrand());
    }
}
