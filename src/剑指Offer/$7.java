package 剑指Offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-01
 */
public class $7 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(7));
    }
    public static int Fibonacci(int n) {
        int result = 0;
        int k = 1;
        int m = 1;
        if (n == 0){
            return 0;
        }else if (n == 1){
            return 1;
        }else if (n == 2){
            return 1;
        }else {
            for (int i = 2; i < n; i++){
                result = k + m;
                m = k;
                k = result;
            }
        }
        return result;
    }
    
    public static int fibonacci(int n){
        if (n == 0){
            return 0;
        }else if (n < 2){
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}
