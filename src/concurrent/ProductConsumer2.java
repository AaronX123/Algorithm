package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 防止虚假唤醒，因此唤醒之后必须放在循环中，因为恢复时会从停止的地方继续执行。
 * notify容易导致死锁，A,B,C三个线程，A,B生产 C消费，产品满的时候，A,B 调用wait进入阻塞，C消费完成后Notify，假如唤醒一个A，A完成后调用notify叫
 * C来消费，但是由于是唤醒一个线程，因此如果唤醒B，则会导致死锁。
 */
public class ProductConsumer2 {
    static class Source{
        int temp;
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        public Source() {
            this.temp = 0;
        }
        public void set(int a){
            lock.lock();
            try {
                temp = a;
            }finally {
                lock.unlock();
            }
        }

        public void incr() throws InterruptedException {
            lock.lock();
            try {
                while (temp >= 3){
                    condition.await();
                }
                temp++;
                System.out.println(Thread.currentThread().getName() + "生产1个，总共:" + temp + " 个");
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }

        public void decr() throws InterruptedException {
            lock.lock();
            try {
                while (temp == 0){
                    condition.await();
                }
                temp--;
                System.out.println(Thread.currentThread().getName() + "取出1个，总共:" + temp + "个");
                condition.signalAll();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Source s = new Source();
        Thread a = new Thread(() -> {


        });
        Thread a2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    s.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    s.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    s.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        a2.start();
        b.start();
        b2.start();
    }
}
