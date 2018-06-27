package com.fs.demothread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ASUS
 */
public class AtomicIntegerTest {
    static AtomicInteger i=new AtomicInteger();
    static int COUNT=100000;
    static class AddInteger implements Runnable{

        @Override
        public void run() {
            for (int j = 0; j <COUNT ; j++) {
                i.incrementAndGet();
            }
        }
    }
    public static void main(String[] args) {
        Thread[] tr=new Thread[10];
        for (int j = 0; j <tr.length ; j++) {
            tr[j]=new Thread(new AddInteger());
        }
        for (int j = 0; j < tr.length; j++) {
            tr[j].start();
        }
        for (int j = 0; j < tr.length; j++) {
            try {
                tr[j].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);
    }
}
