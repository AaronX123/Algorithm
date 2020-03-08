package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * 当GC只能回收2%内存空间时，抛出OOM GC Over Limit
 */
public class GcOverLimitException {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
       try {
           while (true){
               list.add(String.valueOf(i++).intern());
           }
       }catch (Throwable e){
           System.out.println("--------------" + i);
           e.printStackTrace();
           throw e;
       }
    }
}
