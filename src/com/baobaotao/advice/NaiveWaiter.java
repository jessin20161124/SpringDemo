package com.baobaotao.advice;

/**
 * Created by gzx on 16-11-14.
 */
public class NaiveWaiter implements Waiter {

    /**
     * 业务类，实现想要的具体业务，而与日志/监控等无关
     * @param name
     */
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name + "...");
    }
}
