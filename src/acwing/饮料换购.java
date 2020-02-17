package acwing;

import java.util.Scanner;

/**
 * 乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料，并且可以一直循环下去(但不允许暂借或赊账)。
 *
 * 请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的 n 瓶饮料，最后他一共能喝到多少瓶饮料。
 *
 * 输入格式
 * 输入一个整数 n,表示初始买入的饮料数量。
 *
 * 输出格式
 * 输出一个整数，表示一共能够喝到的饮料数量。
 *
 * 数据范围
 * 0<n<10000
 * 输入样例：
 * 100
 * 输出样例：
 * 149
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 饮料换购 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        System.out.println(drinkableCount(n));
    }

    public static int drinkableCount(int n){
        if (n < 3){
            return n;
        }
        int res = n;
        while (n >= 3){
            res ++;
            n -= 3;
            n ++;
        }
        return res;
    }
}
