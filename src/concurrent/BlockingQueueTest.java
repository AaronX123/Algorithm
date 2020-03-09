package concurrent;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
    /**
     * ArrayBlockingQueue是限制队列长度，当新加入的元素超过长度，如果设置了等待时间，超时就抛出异常
     */
    static volatile BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(3);

    /**
     * SynchronousQueue是每次只存入1个元素，当另外元素入队时会阻塞，当元素取出后才能继续入队
     */
    static volatile BlockingQueue<Integer> synchronousQueue = new SynchronousQueue<>();
    public static void main(String[] args) {
        testSynchronousQueue();
    }

    public static void testSynchronousQueue() {
        Thread a = new Thread(() -> {
            try {
                synchronousQueue.put(1);
                System.out.println(1);
                synchronousQueue.put(2);
                System.out.println(2);
                synchronousQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread b = new Thread(() ->{
            try {

                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1100);
                    System.out.println("取出"+synchronousQueue.take());
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        a.start();
        b.start();
    }

    public static void testArrayBlockingQueue() {
        Thread a = new Thread(() -> {
            blockingQueue.add(1);
            blockingQueue.add(2);
            blockingQueue.add(3);
            try {
                blockingQueue.offer(4,2, TimeUnit.SECONDS);
                System.out.println("插入5是否成功：" + blockingQueue.offer(5,2,TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread b = new Thread(() -> {
            try {
                while (!blockingQueue.isEmpty()){
                    System.out.println("获取:" + blockingQueue.take());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
    }

}
