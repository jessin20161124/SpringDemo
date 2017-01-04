package com.baobaotao.advisor;

import com.baobaotao.proxy.ForumService;
import com.baobaotao.introduce.Monitorable;
import com.baobaotao.proxy.ForumServiceImpl;
import org.springframework.aop.IntroductionAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gzx on 16-11-15.
 */
public class Test {
    public static void main(String[] args){
        String configPath = "com/baobaotao/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        /**
         * 显然，只有waiter的greetTo方法被拦截
         */
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        Seller seller = (Seller)ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("John");
        seller.greetTo("John");

        System.out.println("--------------正则表达式切面-------------");
        Waiter waiter1 = (Waiter)ctx.getBean("waiter1");
        waiter1.serveTo("Tom");
        waiter1.greetTo("Tom");

        System.out.println("------------动态切面-------------");
        Waiter waiter2 = (Waiter)ctx.getBean("waiter2");
        waiter2.serveTo("Peter");
        waiter2.greetTo("Peter");
        waiter2.serveTo("John");
        waiter2.greetTo("John");

        System.out.println("------------流程切面--------------------");
        Waiter waiter3 = (Waiter)ctx.getBean("waiter3");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter3);
        waiter3.greetTo("Peter");
        waiter3.serveTo("Peter");
        wd.service("Peter");

        System.out.println("--------------符合切点----------------");
        Waiter waiter4 = (Waiter)ctx.getBean("waiter4");
        WaiterDelegate wd1 = new WaiterDelegate();
        wd1.setWaiter(waiter4);
        waiter4.greetTo("Tom");
        waiter4.serveTo("Tom");
        wd1.service("Tom");

        System.out.println("--------------引入切面--------------------");
        ForumServiceImpl fs = (ForumServiceImpl)ctx.getBean("forumService");
        fs.removeForum(10);
        ((Monitorable)fs).setMonitorActive(true);
        fs.removeForum(100);
    }
}
