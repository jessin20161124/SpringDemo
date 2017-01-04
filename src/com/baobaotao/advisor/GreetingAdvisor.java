package com.baobaotao.advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by gzx on 16-11-15.
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {
    /**
     * 方法只匹配greetTo方法
     * @param method
     * @param aClass
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "greetTo".equals(method.getName());
    }
    @Override
    public ClassFilter getClassFilter(){
        return new ClassFilter(){
            /**
             * 过滤出waiter的子类
             * @param aClass
             * @return
             */
            @Override
            public boolean matches(Class<?> aClass) {
                return Waiter.class.isAssignableFrom(aClass);
            }
        };
    }
}
