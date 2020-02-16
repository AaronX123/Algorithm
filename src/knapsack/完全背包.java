package knapsack;

import java.util.Scanner;

/**
 * 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
 *
 * 第 i 种物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 *
 * 接下来有 N 行，每行两个整数 vi,wi，用空格隔开，分别表示第 i 种物品的体积和价值。
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
 * 10
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-15
 */
public class 完全背包 {
    static int MAX = 1001;
    public static int solution(int[] v, int w[], int n, int m){
        int[][] dp = new int[MAX][MAX];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <=m; j++) {
                for (int k = 0; k * v[i] <= j; k++) {
                    // 这里比较的为什么是dp[i][j]，因为在对k的循环中，已经更新了
                    dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] v = new int[MAX];
        int[] w = new int[MAX];
        for (int i = 1; i <= n; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
        }
        System.out.println(solution(v,w,n,m));
    }

    /**
     * 优化版本
     * 外层i的循环意味着当获取第i件物品时，内层j意味着容积为j （j<=m）时能够取到的最大值
     * 每次i循环时均会比较上一次i - 1时取到的最大值和当前i时取到的值。
     *
     * i = 1; j = 1
     * dp[1] = max(dp[1],dp[1 - 1] + w[1]) = 2;
     * i = 1; j = 2
     * dp[2] = max(dp[2],dp[2 - 1] + w[1]) = 2 + 2 = 4;
     * i = 1; j = 3
     * dp[3] = max(dp[3],dp[3 - 1] + w[1]) = dp[2] + w[1] = 6
     * .
     * .
     * .
     * dp[5] = max(dp[5],dp[5 - 1] + w[1]) = dp[4] + w[1] = 10
     *
     * i = 2; j = v[2] = 2
     * dp[2] = max(dp[2],dp[2 - 2] + w[2]) = 4;
     * i = 2; j = 3
     * dp[3] = max(dp[3],dp[3 - 2] + w[2]) = max(6,2 + 4) = 6;
     * i = 2; j = 4
     * dp[4] = max(dp[4],dp[4 - 2] + w[2]) = 8
     * i = 2; j = 5
     * dp[5] = max(dp[5],dp[5 - 2] + w[2]) = 10
     * @param v
     * @param w
     * @param n
     * @param m
     * @return
     */
    public static int solution2(int[] v, int w[], int n, int m){
        int[] dp = new int[MAX];
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j<=m ; j++) {
                dp[j] = Math.max(dp[j],dp[j - v[i]] + w[i]);
            }
        }
        return dp[m];
    }

}
