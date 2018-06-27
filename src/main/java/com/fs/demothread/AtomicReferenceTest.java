package com.fs.demothread;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author ASUS
 */
public class AtomicReferenceTest {
    static final AtomicReference<String> A=new AtomicReference<>("abc");
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            final int num=i;
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(Math.abs((int)Math.random()*100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (A.compareAndSet("abc","def")){
                        System.out.println(Thread.currentThread().getId()+"success");
                    }else {
                        System.out.println(Thread.currentThread().getId()+"failed");
                    }
                }
            }.start();
        }
    }
}
