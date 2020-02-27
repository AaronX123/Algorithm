package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-22
 */
public class CommonTest {
    public static void main(String[] args) {
        List l1 = new ArrayList();
        l1.add(2);
        l1.add(4);
        List list = l1;
        List ls = list;
        System.out.println(ls.get(1));
    }
}
