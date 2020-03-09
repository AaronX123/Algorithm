package concurrent;

import java.util.concurrent.*;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-02
 */
public class ThreadPoolExecutorTest {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
    ExecutorService fixedThreadPoolExecutors = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"有界阻塞队列线程池");
        }
    });
    /**
     * 可扩容的队列
     */
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    ExecutorService cachedThreadPoolExecutor = new ThreadPoolExecutor(0, 10, 10, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r,"可扩容的阻塞队列线程池");
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());

    ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    ExecutorService singleThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), (r) -> {return new Thread(r,"单线程池");}, (r,poolExecutor) -> {
        System.out.println(poolExecutor.getClass().getClassLoader());
    });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutorTest t = new ThreadPoolExecutorTest();
        for (int i = 0; i < 10; i++) {
            final int te = i;
            t.fixedThreadPool.execute(() ->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            });

        }
    }

    static class MyWorker implements Runnable, Callable{
        int a;

        public MyWorker(int a) {
            this.a = a;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {

        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Object call() throws Exception {
            Thread.sleep(1000);
            return a + "DDL";
        }
    }
}


