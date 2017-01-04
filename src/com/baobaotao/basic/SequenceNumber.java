package com.baobaotao.basic;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;

/**
 * Created by gzx on 16-11-17.
 */
public class SequenceNumber {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
      public Integer initialValue(){
          return 0;
      }
    };
    public int getNextNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }
    private static class TestClient extends Thread{
        private SequenceNumber sn;
        public TestClient(SequenceNumber sn){
            this.sn = sn;
        }
        public void run(){
            for(int i = 0; i < 3; i++){
                System.out.println("thread[" + Thread.currentThread().getName() + "]sn[" + sn.getNextNum() + "]");
            }
        }
    }

    public static void main(String[] args){
        SequenceNumber seq = new SequenceNumber();
        TestClient t1 = new TestClient(seq);
        TestClient t2 = new TestClient(seq);
        TestClient t3 = new TestClient(seq);
        t1.start();
        t2.start();
        t3.start();

    }
}
