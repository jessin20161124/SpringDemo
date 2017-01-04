package com.baobaotao.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by gzx on 16-11-14.
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {

    /**
     * 插入的内容
     */
    @Override
    public void before(Method method, Object[] args, Object obj) throws Throwable {
        System.out.println(obj.getClass().getName() + "." + method.getName());
        String clientName = (String)args[0];
        System.out.println("How are you! Mr." + clientName + ".");
    }
}
