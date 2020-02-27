package acwing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定 n 个自然数，求没有在这 n 个自然数中出现过的最小的自然数是多少。
 *
 * 注意，0 也是自然数。
 *
 * 输入格式
 * 第一行输入一个正整数 n。
 *
 * 第二行输入给定的 n 个自然数，相邻两个自然数之间用一个空格隔开。
 *
 * 输出格式
 * 输出只有一行，一个自然数，表示没有在输入的 n 个自然数中出现过的最小的自然数。
 *
 * 数据范围
 * 1≤n≤1000,
 * 输入的 n 个自然数都不大于 1000。
 *
 * 输入样例1：
 * 7
 * 2 1000 7 0 1 2 5
 * 输出样例1：
 * 3
 * 输入样例2:
 * 5
 * 1 2 3 4 5
 * 输出样例2：
 * 0
 * 样例解释
 * 样例 1 中，输入的自然数中，0、1、2 出现了，3 没有出现，所以答案是 3。
 *
 * 样例 2 中，输入的自然数中，0 没有出现，所以答案是 0。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-20
 */
public class 出现 {

    public static int solution(int[] array){
        Arrays.sort(array);
        int[] hash = new int[array.length];
        if (array[0] > 0){
            return 0;
        }else if (array.length == 1){
            return 1;
        }
        else {
            for (int i : array) {
                hash[i]++;
            }
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] == 0){
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = s.nextInt();
            }
            System.out.println(solution(arr));
        }
    }
}
