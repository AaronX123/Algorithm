package concurrent;

public class YieldJoinAwaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"work");
        },"a");
        Thread b = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"work");
        },"b");
        Object o = new Object();
        Thread c = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"work");
            try {
                synchronized (o){
                    Thread.currentThread().wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("被唤醒");
        },"c");

        Thread d = new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"work");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
                Thread.currentThread().notify();
            }
        },"d");
        a.start();
        b.start();
        c.start();
        d.start();
        d.join();
    }
}
