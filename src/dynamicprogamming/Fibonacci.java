package dynamicprogamming;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-12-11
 */
public class Fibonacci {

    public static int calc(int a){
        int[] dp = new int[a];
        for (int i = 0; i < a; i++) {
            if (i < 2){
                dp[i] = 1;
            }else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[a -1];
    }
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.print(calc(i) + " ");
        }

    }
}
