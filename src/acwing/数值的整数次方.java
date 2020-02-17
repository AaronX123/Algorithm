package acwing;

/**
 * 实现函数double Power(double base, int exponent)，求base的 exponent次方。
 *
 * 不得使用库函数，同时不需要考虑大数问题。
 *
 * 注意：
 *
 * 不会出现底数和指数同为0的情况
 * 样例1
 * 输入：10 ，2
 *
 * 输出：100
 * 样例2
 * 输入：10 ，-2
 *
 * 输出：0.01
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 数值的整数次方 {
    public double Power(double base, int exponent) {
        double res = 1;
        while (exponent != 0){
            if ((exponent & 1) != 0){
                res *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return res;
    }
}
