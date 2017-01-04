package com.baobaotao.advisor;

/**
 * Created by gzx on 16-11-16.
 */
public class WaiterDelegate {
    private Waiter waiter;

    /**
     * 所有在这里被调用的waiter方法都会被植入前向增强，这也就是流程切面的原理
     * waiter调用自己的方法将不会植入增强
     * @param clientName
     */
    public void service(String clientName){
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }
    public void setWaiter(Waiter waiter){
        this.waiter = waiter;
    }
}
