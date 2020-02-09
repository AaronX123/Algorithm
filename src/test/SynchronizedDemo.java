package test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-17
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedDemo {
    private static volatile int i = 0;
    private static volatile int j = 0;

    public static void main(String[] args) {
        Runnable thread1  = new Runnable() {

            @Override
            public void run() {
                while(true)
                    selfPlus();
            }
        };

        Runnable thread2 = new Runnable() {

            @Override
            public void run() {
                while(true)
                    print();
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(thread1);
        pool.execute(thread2);
        pool.shutdown();
    }

    public static synchronized void selfPlus() {
//        if(i != j)
//        System.out.println("selfPlus: i= "+i+" ; j= "+j);
        i++;
        j++;
//        if(i != j)
//        System.out.println("selfPlus: i= "+i+" ; j= "+j);
    }

    public static void print(){
        if(i < j)
            System.out.println("i= "+i+" ; j= "+j);
    }

}
