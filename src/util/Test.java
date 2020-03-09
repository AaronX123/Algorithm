package util;

import jdk.nashorn.internal.parser.JSONParser;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer,String> map = new WeakHashMap<>();
        Integer k1 = new Integer(1);
        String val = new String("14");
        map.put(k1,val);
        map.put(2,"St1");
        System.out.println(map);
        k1 = null;
        System.gc();
        System.out.println(map);

        System.out.println(map);
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Object o1 = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,referenceQueue);
        // 虚引用总是返回null
        phantomReference.get();
//        o = 5;
//        new Test().d(5,0);
//        System.out.println(Arrays.toString(array));
    }
    static int[] array = new int[8];
    static int i = 7;
    static int depth = 0;
    static int o = 0;
    public void d(int cur, int depth){
        if (cur >> 1 == 0){
            array[i] = cur;
            i--;
            return;
        }
        d(cur >> 1,depth++);
        if (o >> (depth + 1) == 0){
            array[i] = o >> depth;
            i--;
        }
    }
}
