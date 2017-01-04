package com.baobaotao.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gzx on 16-11-14.
 * 前置增强和后置增强的设置
 */
public class TestBeforeAdviceConfig {
    public static void main(String[] args){
        String configPath = "com/baobaotao/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        waiter.greetTo("gzx");
        /**
         * 测试环绕增强，即包含前置和后置
         */
        Waiter waiter2 = (Waiter)ctx.getBean("waiter2");
        waiter2.greetTo("gzx");

        ForumService fs = (ForumService)ctx.getBean("forumService");
     //   fs.removeForum(11);
        try {
            fs.updateForum();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
