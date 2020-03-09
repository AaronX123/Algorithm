package concurrent.lock;

public class DeadLock {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread a = new Thread(() ->{
            synchronized (o1){
                System.out.println("A获取o1,尝试获取o2");
                synchronized (o2){
                    System.out.println("A获取o2成功");
                }
            }
        });

        Thread b = new Thread(() -> {
            synchronized (o2){
                System.out.println("B获取o2,尝试获取o1");
                synchronized (o1){
                    System.out.println("B获取o1成功");
                }
            }
        });
        a.start();
        b.start();
    }
}
