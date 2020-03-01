package concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChildThreadExceptionCollect {
    static volatile Map<Thread,String> childErrorMsg = new ConcurrentHashMap<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread c1 = new Thread(() -> {
            for (int i = 4; i >= 0; i--) {
                try {
                    System.out.println(5/i);
                }catch (Exception e){
                    childErrorMsg.put(Thread.currentThread(),e.getLocalizedMessage());
                }
            }
        });
        Thread c2 = new Thread(() -> {
            for (int i = 4; i >= 0; i--) {
                try {
                    System.out.println(5/i);
                }catch (Exception e){
                    childErrorMsg.put(Thread.currentThread(),e.getLocalizedMessage());
                }
            }
        });
        c2.start();
        c1.start();
        while (true){
            Thread.sleep(100);
            System.out.println(childErrorMsg);
        }
    }
}
