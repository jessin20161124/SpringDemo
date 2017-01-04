package com.baobaotao.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by gzx on 16-11-14.
 */
public class TestBeforeAdvice {
    public static void main(String[] args){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        ProxyFactory pf = new ProxyFactory();
        //前置增强
        pf.setTarget(target);
        pf.addAdvice(advice);
        // 生成代理实例
        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}
