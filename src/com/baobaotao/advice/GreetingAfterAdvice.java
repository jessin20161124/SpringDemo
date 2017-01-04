package com.baobaotao.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by gzx on 16-11-14.
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {
    /**
     * 后置增强
     * @param o
     * @param method
     * @param objects
     * @param o1
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}
