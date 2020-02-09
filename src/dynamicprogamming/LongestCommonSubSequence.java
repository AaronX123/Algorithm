package dynamicprogamming;

/**
 * 最长公共子序列
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-12-11
 */
public class LongestCommonSubSequence {

    public static int calc(String str1,String str2){
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        for (int i = 0; i< c1.length; i++){
            dp[i][0] = 0;
        }
        for (int i = 0; i < c2.length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                int a = dp[i+1][j] > dp[i][j+1] ? dp[i+1][j] : dp[i][j+1];
                if (c1[i] == c2[j]){
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                }else {
                    dp[i + 1][j + 1] = a;
                }
            }
        }
        return dp[c1.length][c2.length];
    }

    public static void main(String[] args) {
        System.out.println(calc("abcdeab","feabdfg"));
    }
}
