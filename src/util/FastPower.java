package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class FastPower {
    public static int fastPower(int a, int b) {
        int ans = 1;
        int base = a;
        while (b != 0) {
            // 如果当前的次幂数最后一位(二进制数)不为0的话，那么我们将当前权值加入到最后答案里面去
            if ((b & 1) != 0) {
                ans = ans * base;
            }
            //权值增加
            base = base * base;
            b >>= 1;
        }
        return ans;
    }
}
