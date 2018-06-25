package com.fs.demothread;

/**
 * @author ASUS
 */
public class ThreadTest {
    public volatile static int i=0;
    public static class UserThread extends Thread{
        @Override
        public void run() {
            for (i=0;i<10000;i++){
                System.out.println("---");
            }
        }
    }
    public static void main(String[] args) {
        UserThread userThread = new UserThread();
        //设置为守护线程(后台运行)  但是它不会作为虚拟机退出的标志
        userThread.setDaemon(true);
        userThread.start();
        /*try {
            *//**'
             * 等待线程结束
             * 本质是系统会判断线程是否存活
             * while(isAlive())｛
             *      wait(0)
             * ｝
             * 当线程结束后，系统会调用notify()
             *//*
            userThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println(i);
    }
}
