package com.fs.demothread;

/**
 * @author ASUS
 * 如果synchronized作用于实例方法上面，表示对当前对象枷锁
 * 枷锁的对象必须是相同的，否则会出现冲突
 */
public class NumberThread implements Runnable {
    static int i=0;

    /**
     * synchronized作用于实例方法上面，是对当前的对象进行加锁
     * 对象必须相同，否则会出现冲突
     */
    public synchronized void increase(){
        i++;
    }

    /**
     * synchronized作用于实例方法上面作用于静态方法上面，是对当前的类进行枷锁
     */
    public static synchronized void increase1(){
        i++;
    }

    static NumberThread instance=new NumberThread();

    static final int COUNT=10000000;
    @Override
    public void run() {
        /*for (int j=0;j<COUNT;j++){
            synchronized (instance){
                i++;
            }
        }*/
        for (int j = 0; j <COUNT ; j++) {
            //increase();
            increase1();
        }
        synchronized (this){
            try {
                /**
                 * 会使当前对象释放锁
                 */
                instance.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Thread t1 = new Thread(instance);
        //Thread t2 = new Thread(instance);
        Thread t1 = new Thread(new NumberThread());
        Thread t2 = new Thread(new NumberThread());
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
