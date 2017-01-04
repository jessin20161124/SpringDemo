package com.baobaotao.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by gzx on 16-11-14.
 */
public class TransactionManager implements ThrowsAdvice {
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex)throws Throwable{
        System.out.println("-------------");
        System.out.println("method: " + method.getName());
        // getMessage()的内容来自throw new Exception(message)里面的参数
        System.out.println("抛出异常：" + ex.getMessage());
        System.out.println("成功回滚事务。");
    }
}
