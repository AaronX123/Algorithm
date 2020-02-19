package 背包问题;

import java.util.Scanner;

/**
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品数量和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 件物品的体积和价值。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 * 输入样例
 * 4 5
 * 1 2
 * 2 4
 * 3 4
 * 4 5
 * 输出样例：
 * 8
 *
 * 数据范围
 * 0<N,V≤1000
 * 0<vi,wi≤1000
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-14
 */
public class $01背包 {
    /**
     * 取决于数据范围
     */
    static int MAX = 1010;
    public int solution(int[] v, int[] w, int N, int V){
        int[][] dp = new int[MAX][MAX];
        // 循环物品
        for (int i = 1; i <= N ; i++) {
            for (int j = 0; j <= V ; j++) {
                // 不要这个东西
                dp[i][j] = dp[i - 1][j];
                if (j >= v[i]){
                    //
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        return dp[N][V];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] v = new int[MAX];
        int[] w = new int[MAX];
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(new $01背包().solution2(v,w,n,m));
    }

    public int solution2(int[] v, int[] w, int N, int V){
        // 当体积为V时的最大值
        int[] dp = new int[MAX];
        // 循环物品
        for (int i = 1; i <= N ; i++) {
            for (int j = V; j >=v[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - v[i]] + w[i]);
            }
        }
        return dp[V];
    }
}
