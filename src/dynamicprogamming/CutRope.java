package dynamicprogamming;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-12-11
 */
public class CutRope {

    public static int calc(int target){
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        //i为分割次数
        for (int i = 1; i < dp.length; i++) {
            //例：5被分割成5份
            if (target == i){
                dp[i] = 1;
            }else {
                dp[i] = i;
            }
            //j为分割的位置
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j],dp[i]);
            }
        }
        return dp[target];
    }
}
