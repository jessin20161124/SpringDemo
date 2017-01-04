package com.baobaotao.service;

import com.baobaotao.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by gzx on 16-11-19.
 */
//将UserService标志位一个服务层的bean
@Service
public class UserService {
    public void createUser(User user){
        System.out.println("service create user : " + user);
    }
}
