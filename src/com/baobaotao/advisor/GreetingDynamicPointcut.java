package com.baobaotao.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gzx on 16-11-15.
 * 只有满足下面三个要求的类方法才会植入增强，同时，只有通过两个静态方法的类才有可能执行动态方法判断
 * 一个动态代理实例的符合要求的方法第二次开始会只执行动态方法判断
 * 不符合要求的不用判断，不能植入。
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<String>();
    static{
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    /**
     * 类过滤器，过滤Waiter类
     * @return
     */
    public ClassFilter getClassFilter(){
        return new ClassFilter(){
          public boolean matches(Class clazz){
              System.out.println("调用getClassFilter对" + clazz.getName() + "做静态检查");
              return Waiter.class.isAssignableFrom(clazz);
          }
        };
    }

    /**
     * 静态代理方法，主要是匹配方法greetTo
     * @param method
     * @param clazz
     * @return
     */
    public boolean matches(Method method, Class clazz){
        System.out.println("调用matches(method, clazz)" + clazz.getName() + "." + method.getName() + "做静态检查.");
        return "greetTo".equals(method.getName());
    }

    /**
     * 动态代理的关键方法
     * @param method
     * @param clazz
     * @param args
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> clazz, Object[] args) {
        System.out.println("调用matches(method,clazz)" + clazz.getName() + "." + method.getName() + "做动态检查.");
        String clientName = (String)args[0];
        return specialClientList.contains(clientName);
    }
}
