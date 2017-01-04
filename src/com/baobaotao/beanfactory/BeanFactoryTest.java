package com.baobaotao.beanfactory;
import com.baobaotao.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.beans.factory.xml.XmlBeanFactory;
/**
 * Created by gzx on 16-11-10.
 */
public class BeanFactoryTest {
    public static void main(String[] args){
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:com/baobaotao/beanfactory/beans.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println("init bean factory");
        Car car = bf.getBean("car1", Car.class);
        System.out.println("car bean is ready to use!");
        System.out.println(car);
    }
}
