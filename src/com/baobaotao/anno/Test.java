package com.baobaotao.anno;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/**
 * Created by gzx on 16-11-11.
 */
public class Test {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/baobaotao/beanfactory/beans.xml");
       // ctx.getBean("Boss");
        ((ClassPathXmlApplicationContext)ctx).destroy();
    }
}
