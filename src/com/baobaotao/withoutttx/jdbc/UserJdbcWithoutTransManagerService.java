package com.baobaotao.withoutttx.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
/**
 * Created by gzx on 16-11-17.
 */
@Service("userService")
public class UserJdbcWithoutTransManagerService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addScore(String userName, int toAdd){
        String sql = "update t_user set score = score + ? where user_name = ? ";
        jdbcTemplate.update(sql, toAdd, userName);
    }

    public static void main(String[] args){
        // 每个SQL语句都是一个单独的事务，默认自动提交
        // 注意需要导入依赖包：commons-dbcp.jar commons-pool.jar mysql-connector.jar 包
        // 这里使用Spring Jdbc连接数据库，关键是配置好数据源，不用处理异常，获取连接
        // 需要什么直接操作
        String configPath = "com/baobaotao/withoutttx/jdbc/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        UserJdbcWithoutTransManagerService service = (UserJdbcWithoutTransManagerService)ctx.getBean("userService");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        BasicDataSource ds = (BasicDataSource)jdbcTemplate.getDataSource();
        System.out.println("autocommit = " + ds.getDefaultAutoCommit());
        jdbcTemplate.execute("insert into t_user(user_name, password, score, last_logon_time) values('tom', '123456', 10, " + System.currentTimeMillis() + ")");
        service.addScore("tom", 20);
        // 可能出错，可能没有数据，或者数据多于一条
        int score = jdbcTemplate.queryForObject("select score from t_user where user_name = 'tom' ", Integer.class);
        System.out.println("score = " + score);
    }
}
