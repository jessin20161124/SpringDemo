package com.baobaotao.aspectj.anno;

import java.lang.reflect.Method;

/**
 * Created by gzx on 16-11-16.
 */
public class TestTool {
    public static void main(String[] args){
        Class clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for(Method method : methods){
            NeedTest nt = method.getDeclaredAnnotation(NeedTest.class);
            if(nt != null){
                if(nt.value()){
                    System.out.println(method.getName() + " need test ");
                }
                else{
                    System.out.println(method.getName() + " need not test ");
                }
            }
        }
    }
}
