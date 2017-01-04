package com.baobaotao.anno;

import com.baobaotao.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by gzx on 16-11-11.
 */
@Component
public class Boss {
    private Car car;
    public Boss(){
        System.out.println("boss construct");
    }
    @Autowired
    private void setCar(Car car){
        this.car = car;
        System.out.println("set car");
    }
    @PostConstruct
    private void init1(){
        System.out.println("inti1");
    }
    @PostConstruct
    private void init2(){
        System.out.println("inti2");
    }
    @PreDestroy
    private void destroy1(){
        System.out.println("destroy1");
    }
    @PreDestroy
    private void destroy2(){
        System.out.println("destroy2");
    }
}
