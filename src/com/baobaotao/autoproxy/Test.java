package com.baobaotao.autoproxy;

import com.baobaotao.advisor.Seller;
import com.baobaotao.advisor.Waiter;
import com.baobaotao.advisor.WaiterDelegate;
import com.baobaotao.introduce.Monitorable;
import com.baobaotao.proxy.ForumServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gzx on 16-11-16.
 */
public class Test {
    public static void main(String[] args){
        String configPath = "com/baobaotao/autoproxy/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter = (Waiter)ctx.getBean("waiter");
        Seller seller = (Seller)ctx.getBean("seller");
        waiter.greetTo("John");
        waiter.serveTo("Tom");

        System.out.println("-----------------DefaultAdvisorAutoProxyCreator------------------------");
        String configPath1 = "com/baobaotao/autoproxy/beans1.xml";
        ApplicationContext ctx1 = new ClassPathXmlApplicationContext(configPath1);
        Waiter waiter1 = (Waiter)ctx1.getBean("waiter");
        Seller seller1 = (Seller)ctx1.getBean("seller");
        waiter1.greetTo("John");
        waiter1.serveTo("Tom");
        seller1.greetTo("Amy");
    }
}
