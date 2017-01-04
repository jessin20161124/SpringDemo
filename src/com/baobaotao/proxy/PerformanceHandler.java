package com.baobaotao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by gzx on 16-11-13.
 */
public class PerformanceHandler implements InvocationHandler{
    private Object target;
    public PerformanceHandler(Object target){
        this.target = target;
    }
    // 实现动态代理的关键方法，结合方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object obj = method.invoke(target, args);
        PerformanceMonitor.end();
        return proxy;
    }
}
