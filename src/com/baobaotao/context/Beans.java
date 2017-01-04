package com.baobaotao.context;

import com.baobaotao.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by gzx on 16-11-10.
 */
//@Configuration
public class Beans {
   // @Bean(name="car")
    public Car buildCar(){
        Car car = new Car();
        car.setBrand("hongqi");
        car.setColor("red");
        car.setMaxSpeed(200);
        System.out.println("call buildCar");
        return car;
    }

}
