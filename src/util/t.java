package util;

import java.util.*;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-02
 */
public class t {
    public static void main(String[] args) {
        List<List<Long>> ls = new ArrayList<>();
        List<Long> l1 = new ArrayList<>();
        l1.add(1L);
        l1.add(2L);
        l1.add(3L);
        List<Long> l2 = new ArrayList<>();
        l2.add(4L);
        l2.add(5L);
        l2.add(6L);
        ls.add(l1);
        ls.add(l2);
        Collections.addAll(ls);
    }
}
