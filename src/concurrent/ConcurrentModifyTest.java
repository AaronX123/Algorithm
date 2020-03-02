package concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList内部是依赖ReentrantLock,在进行add,set,remove时会进行lock.lock，然后拷贝新的数组替换原数组，达到了读写分离,无扩容
 */
public class ConcurrentModifyTest {
    static ArrayList<Integer> integerArrayList = new ArrayList<>();
    static Vector<Integer> integerVector = new Vector<>();
    static List<Integer> synchronizedList = null;
    static CopyOnWriteArrayList<Integer> integerCopyOnWriteArrayList = new CopyOnWriteArrayList<>();
    static HashMap<Integer,Integer> integerHashMap = new HashMap<>();
    static ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap<>();
    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            final int temp = i;
//            new Thread(() ->{
//                integerArrayList.add(add(temp));
//                System.out.println(integerArrayList);
//            },"Thread:" + i).start();
//        }
//        for (int i = 0; i < 20; i++) {
//            final int temp = i;
//            new Thread(() ->{
//                integerVector.add(add(temp));
//                System.out.println(integerVector);
//            },"Thread:" + i).start();
//        }
//        synchronizedList = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 0; i < 20; i++) {
//            final int temp = i;
//            new Thread(() ->{
//                synchronizedList.add(add(temp));
//                System.out.println(synchronizedList);
//            },"Thread:" + i).start();
//        }
//        for (int i = 0; i < 20; i++) {
//            final int temp = i;
//            new Thread(() ->{
//                integerCopyOnWriteArrayList.add(add(temp));
//                System.out.println(integerCopyOnWriteArrayList);
//            },"Thread:" + i).start();
//        }
//        for (int i = 0; i < 20; i++) {
////            final int temp = i;
////            new Thread(() ->{
////                integerHashMap.put(add(temp),1);
////                System.out.println(integerHashMap);
////            },"Thread:" + i).start();
////        }
        for (int i = 0; i < 20; i++) {
            final int temp = i;
            new Thread(() ->{
                concurrentHashMap.put(add(temp),1);
                System.out.println(concurrentHashMap);
            },"Thread:" + i).start();
        }
    }

    public static int add(int t){
        try {
            Thread.sleep(200);
            return t + 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
