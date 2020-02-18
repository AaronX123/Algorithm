package acwing;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-18
 */
public class 正则表达式匹配 {
    static boolean[][] dp;
    static int n,m;
    public static boolean isMatch(String s, String p){
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        dp = new boolean[ss.length + 1][ps.length + 1];
        n = ss.length;
        m = ps.length;
        dp[n][m] = true;
        dp(0,0,ss,ps);
        return dp(0,0,ss,ps);
    }

    private static boolean dp(int i, int j, char[] ss, char[] ps){
        if (dp[i][j]){
            return dp[i][j];
        }
        // 模式串匹配完成，判断是否匹配完字符串
        if (j == m){
            return dp[i][j] = i == n;
        }
        // 出现两个串字符相同或者模式串为'.'时则为true
        boolean firstMatch = i < n && (ss[i] == ps[j] || ps[j] == '.');
        boolean ans;
        if (j + 1 < m && ps[j + 1] == '*'){
            // j + 2意味着 *号和之前的一个元素没有被匹配到则跳过
            ans = dp(i,j + 2, ss, ps) || firstMatch && dp(i + 1, j, ss, ps);
        }else {
            ans = firstMatch && dp(i + 1, j + 1, ss, ps);
        }
        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("",".*"));
    }
}
