package concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        /**
         * 证明synchronized是可重入的
         */
//        for (int i = 0; i < 5; i++) {
//            new Thread(() ->{
//                do1();
//            },"Thread:"+i).start();
//        }
        for (int i = 0; i < 5; i++) {
            new Thread(() ->{
            do3();
            },"Thread:"+i).start();
        }
    }
    static void do3(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            do4();
        }finally {
            lock.unlock();
        }
    }
    static void do4(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
    }
    static synchronized void do1(){
        System.out.println(Thread.currentThread().getName());
        do2();
    }
    static synchronized void do2(){
        System.out.println(Thread.currentThread().getName());
    }
}
