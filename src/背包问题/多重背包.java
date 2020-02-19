package 背包问题;

import java.util.Scanner;

/**
 * 有 N 种物品和一个容量是 V 的背包。
 *
 * 第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
 * 输出最大价值。
 *
 * 输入格式
 * 第一行两个整数，N，V，用空格隔开，分别表示物品种数和背包容积。
 *
 * 接下来有 N 行，每行三个整数 vi,wi,si，用空格隔开，分别表示第 i 种物品的体积、价值和数量。
 *
 * 输出格式
 * 输出一个整数，表示最大价值。
 *
 * 数据范围
 * 0<N,V≤100
 * 0<vi,wi,si≤100
 * 输入样例
 * 4 5
 * 1 2 3
 * 2 4 1
 * 3 4 3
 * 4 5 2
 * 输出样例：
 * 10
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-15
 */
public class 多重背包 {
    static int MAX = 101;
    public static int solution(int[] v, int[] w, int[] s, int n, int m){
        int[][] dp = new int[MAX][MAX];
        for (int i = 1; i <= n ; i++) {
            for (int j = m; j >= 0 ; j--) {
                for (int k = 0; k <= s[i]; k++) {
                    if (k * v[i] <= j){
                        dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - k * v[i]] + k * w[i]);
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 背包容积
        int m = scanner.nextInt();
        // 价值
        int[] v = new int[n + 1];
        // 重量
        int[] w = new int[n + 1];
        // 可用次数
        int[] s = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }
        System.out.println(solution(v,w,s,n,m));
    }


}
