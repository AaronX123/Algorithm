package concurrent;

import util.Person;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    static AtomicReference<Person> personAtomicReference = new AtomicReference<>();

//    public static void main(String[] args) {
//        Person xm = new Person(1,"小明1");
//        personAtomicReference.compareAndSet(null,xm);
//        System.out.println(personAtomicReference.get());
//        personAtomicReference.compareAndSet(xm,null);
//        System.out.println(personAtomicReference.get());
//        // ABA
//        personAtomicReference.compareAndSet(null,xm);
//        Person dq = new Person(2,"大强");
//        personAtomicReference.compareAndSet(xm,dq);
//        System.out.println(personAtomicReference.get());
//        personAtomicReference.compareAndSet(dq,xm);
//        personAtomicReference.compareAndSet(xm,null);
//        System.out.println(personAtomicReference.get());
//    }
    public static void main(String[] args) throws InterruptedException {
        Person xm = new Person(1,"小明");
        Person dq = new Person(2,"大强");
        Thread a = new Thread(() -> {
            personAtomicReference.compareAndSet(null,xm);
            System.out.println(personAtomicReference.get());
            try {
                Thread.sleep(5000);
                while (personAtomicReference.compareAndSet(xm,null)){
                    System.out.println("解锁");
                }
                System.out.println(personAtomicReference.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"1");
        a.start();
        Thread.sleep(100);

        Thread b = new Thread(() ->{
            personAtomicReference.compareAndSet(xm,dq);
            try {
                Thread.sleep(1000);
                System.out.println(personAtomicReference.get());
                personAtomicReference.compareAndSet(dq,xm);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        b.start();
    }
}

