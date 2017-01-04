package com.baobaotao.introduce;

import com.baobaotao.proxy.ForumService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gzx on 16-11-14.
 * 引入增强测试：增加了新的方法可以用
 */
public class TestIntroduce {
    public static void main(String[] args){
        String configPath = "com/baobaotao/introduce/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService fs = (ForumService)ctx.getBean("forumService");
        fs.removeTopic(10);
        fs.removeForum(1022);
        // 代理实例可以变为被实现的接口
        ((Monitorable)fs).setMonitorActive(true);
        fs.removeTopic(10);
        fs.removeForum(1022);
    }
}
