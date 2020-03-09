package concurrent;

import util.Person;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {
    static AtomicStampedReference<Person> personAtomicStampedReference = new AtomicStampedReference<>(null,1);
    static AtomicInteger i = new AtomicInteger(1);
    public static void main(String[] args) {
        Person xm = new Person(1,"小明1");

        Person dq = new Person(2,"大强");
        personAtomicStampedReference.compareAndSet(null,xm,1,i.incrementAndGet());
        int[] stampHolder = new int[5];
        System.out.println(personAtomicStampedReference.get(stampHolder));
        System.out.println(personAtomicStampedReference.compareAndSet(xm,dq,i.get(),i.getAndIncrement()));
        System.out.println(personAtomicStampedReference.get(stampHolder));
    }
}

