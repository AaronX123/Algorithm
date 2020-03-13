package 大厂笔试;

import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-11
 */
public class 字节跳动2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        n = 1024 - n;
        int res = 0;
        while (n > 0){
            if (n - 64 >= 0){
                res++;
                n -=64;
            }else if (n - 16 >= 0){
                res++;
                n -=16;
            }else if (n - 4 >= 0){
                res++;
                n -=4;
            }else if (n - 1 >= 0){
                res++;
                n -=1;
            }
        }

        System.out.println(res);
    }
}
