package acwing;

import java.util.Scanner;

/**
 * 有 n 名学生参加军训，军训的一大重要内容就是走队列，而一个队列的不整齐程度是该队中最高的学生的身高与最矮的学生的身高差值的平方。
 *
 * 现在要将 n 名参加军训的学生分成 k 个队列，每个队列的人数可以是任意非负整数。
 *
 * 在安排队列时希望所有队列的不整齐度之和尽量小，请问不整齐度之和最小可以是多少？
 *
 * 输入格式
 * 第一行两个整数 n,k，表示学生人数和队列数。
 *
 * 第二行 n 个整数，依次表示每名学生的身高。
 *
 * 输出格式
 * 一个整数表示答案。
 *
 * 数据范围
 * 对于10%的数据，k=1；
 * 对于另外10%的数据，k=2；
 * 对于另外10%的数据，k=3；
 * 对于另外10%的数据，k=4；
 * 对于另外10%的数据，1≤n,k≤5；
 * 对于另外10%的数据，1≤n,k≤10；
 * 对于另外20%的数据，1≤n,k≤100；
 * 对于另外5%的数据，n=k=500
 * 对于所有的数据，1≤n,k≤500，0≤ 学生身高 ≤200
 * 输入样例：
 * 3 2
 * 170 180 168
 * 输出样例：
 * 4
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-20
 */
public class 军训队列 {
    public static int solution(int n, int queueCount, int[] student){
        return 0;
    }


    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)){
            int n = s.nextInt();
            int queueCount = s.nextInt();
            int[] student = new int[n];
            for (int i = 0; i < student.length; i++) {
                student[i] = s.nextInt();
            }

        }
    }
}
