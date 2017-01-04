package com.baobaotao.proxy;

/**
 * Created by gzx on 16-11-13.
 */
public class PerformanceMonitor {
    public static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();
    public static void begin(String method){
        System.out.println("begin monitor....");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }
    public static void end(){
        System.out.println("end monitor....");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }
}
