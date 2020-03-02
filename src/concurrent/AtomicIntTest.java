package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntTest {
    private static AtomicInteger integer = new AtomicInteger(5);

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                integer.compareAndSet(5,2);
//                System.out.println("值为："+integer.getAndDecrement());
//            },i + "").start();
//        }
        integer.compareAndSet(5,2);
        integer.compareAndSet(2,3);
        System.out.println(integer.get());
    }
}
