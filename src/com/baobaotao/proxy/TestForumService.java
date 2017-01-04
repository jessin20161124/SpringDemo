package com.baobaotao.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by gzx on 16-11-13.
 * 动态代理：Spring AOP的实现机制
 */
public class TestForumService {
    public static void main(String[] args){
        ForumService target = new ForumServiceImpl(); // 业务逻辑
        PerformanceHandler handler = new PerformanceHandler(target); // 在业务逻辑的基础上包含监听
        // 获取代理
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        proxy.removeForum(10); // 触发包装的方法
        proxy.removeTopic(1012);
    }
}
