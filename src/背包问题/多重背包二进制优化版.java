package 背包问题;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 将s个物品通过二进制拆分为k小份，然后构造出k * v[i], k * w[i]这样的新物品，这样就转换成01背包问题
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-15
 */
public class 多重背包二进制优化版 {
    static int MAX = 101;

    static class ValueHolder{
        int v,w;

        public ValueHolder(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 背包容积
        int m = scanner.nextInt();
        // 体积
        int[] v = new int[n + 1];
        // 价值
        int[] w = new int[n + 1];
        // 数量
        int[] s = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            v[i] = scanner.nextInt();
            w[i] = scanner.nextInt();
            s[i] = scanner.nextInt();
        }
        System.out.println(solution(v,w,s,n,m));
    }


    public static int solution(int[] v, int[] w, int[] s, int n, int m){
        int[] dp = new int[m + 1];
        ArrayList<ValueHolder> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int s2 = s[i];
            for (int k = 1; k < s2; k *= 2){
                s2 -= k;
                arrayList.add(new ValueHolder(v[i] * k, w[i] * k));
            }
            if (s2 >= 0){
                arrayList.add(new ValueHolder(v[i] * s2, w[i] * s2));
            }
        }

        for (ValueHolder holder : arrayList) {
            for (int j = m; j >= holder.v ; j--) {
                dp[j] = Math.max(dp[j],dp[j - holder.v] + holder.w);
            }
        }
        return dp[m];
    }

}
