package test;

import java.util.Random;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-18
 */
public class Thread {

    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
// 业余草：www.xttblog.com
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        Random r = new Random();
        ;
        String a = "aa";
        StringBuilder sb = new StringBuilder();
        sb.deleteCharAt(sb.length()-1);
        System.out.println(r.nextInt(10));
    }
}
