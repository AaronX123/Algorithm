package concurrent.lock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantLock 只允许一个线程进行读写，粒度大，因此使用ReentrantReadWriteLock
 */
public class ReadWriteLockTest {
    static ReadWriteLock lock = new ReentrantReadWriteLock();
    static volatile List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        ReadWriteLockTest test = new ReadWriteLockTest();
        for (int i = 0; i < 20; i++) {
            final int t = i;
            new Thread(() ->{
                test.add(t);
                test.read();
            }).start();
        }
    }

    public void read(){
        lock.readLock().lock();
        System.out.println(list);
        lock.readLock().unlock();
    }

    public void add(int a){
        lock.writeLock().lock();
        try {
            list.add(a);
        }finally {
            lock.writeLock().unlock();
        }
    }
}
