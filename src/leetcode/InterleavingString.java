package leetcode;

/**
 * 给出三个字符串s1, s2, s3,判断s3是否可以由s1和s2交织而成。
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-12-13
 */
public class InterleavingString {

    /**
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        //将字符串转换成数组形式
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        char[] ch3 = s3.toCharArray();

        //dp[i][j]表示s3的前i+j个字符能否由s1的前i个字符和s2的前j的字符交叉组成
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;

        //只取s1的前i个字符去与s3的前i个字符匹配，得到dp[i][0]的值
        for(int i = 1; i <= len1; i++){
            dp[i][0] = dp[i-1][0] && (ch1[i-1] == ch3[i-1]);
        }

        //只取s2的前j个字符去与s3的前j个字符匹配，得到dp[0][j]的值
        for(int j = 1; j <= len2; j++){
            dp[0][j] = dp[0][j-1] && (ch2[j-1] == ch3[j-1] );
        }

        //取s1的前i个字符和s2的前j个字符去与s3的前i+j个字符匹配，得到dp[i][j]的值
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //dp[i][j]的值为true（s1的前i个字符和s2的前j个字符能交叉组成s3的前i+j个字符）是以下两种情况，满足其一即可：
                //(1)dp[i-1][j] && ch1[i-1] == ch3[i+j-1],即s1的前i-1个字符和s2的前j个字符能交叉组成s3的前i+j-1个字符，并且s1的第i个字符等于s3的第i+j字符，说明s1的前i个字符和s2的前j个字符也能交叉组成s3的前i+j个字符
                //(2)dp[i][j-1] && ch2[j-1] == ch3[i+j-1],即s1的前i个字符和s2的前j-1个字符能交叉组成s3的前i+j-1个字符，并且s2的第j个字符等于s3的第i+j字符，说明s1的前i个字符和s2的前j个字符也能交叉组成s3的前i+j个字符
                dp[i][j] = (dp[i-1][j] && ch1[i-1] == ch3[i+j-1]) || (dp[i][j-1] && ch2[j-1] == ch3[i+j-1]);
            }
        }
        return dp[len1][len2];

    }
}
