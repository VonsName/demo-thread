package com.fs.demothread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentTrant implements Runnable {
    public static ReentrantLock lock=new ReentrantLock();
    public static int i=0;
    @Override
    public void run() {
        for (int j = 0; j < 10; j++) {
            lock.lock();
            try {
                i++;
                System.out.println(Thread.currentThread().getId());
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentTrant reentTrant = new ReentTrant();
        Thread t1 = new Thread(reentTrant);
        Thread t2=new Thread(reentTrant);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
    
}
