package test;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-11
 */
public class Volatile {

    public static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        new Thread(threadA, "threadA").start();
        Thread.sleep(1000L);//为了保证threadA比threadB先启动，sleep一下
        new Thread(threadB, "threadB").start();
    }

    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + " : flag is " + flag);
                    break;
                }
            }

        }

    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            flag = true;
            System.out.println(Thread.currentThread().getName() + " : flag is " + flag);
        }
    }
}