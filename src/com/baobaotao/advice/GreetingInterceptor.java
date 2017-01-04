package com.baobaotao.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by gzx on 16-11-14.
 */
public class GreetingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String)args[0];
        System.out.println("before the task..." + clientName);
        Object obj = methodInvocation.proceed();
        System.out.println("After the task..." + clientName);
        return obj;
    }
}
