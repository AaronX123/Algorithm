package 剑指Offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-11
 */
public class $48 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean f = n > 0 && (sum += Sum_Solution(n - 1)) != -999;
        return sum;
    }
}
