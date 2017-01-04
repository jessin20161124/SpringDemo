package com.baobaotao.advisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

/**
 * Created by gzx on 16-11-16.
 */
public class GreetingComposablePointcut {
    public Pointcut getIntersectionPointcut(){
        ComposablePointcut cp = new ComposablePointcut();
        Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class, "service");
        NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
        pt2.addMethodName("greetTo");
        //将两个切点进行交集操作
        return cp.intersection(pt1).intersection((Pointcut)pt2);
    }
}
