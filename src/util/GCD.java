package util;

/**
 * 欧几里得算法gcd(辗转相除法)
 * Greatest Common Divisor
 * Minimum common multiple
 * 求最大公约数
 * [a,b] ：a b之间的最小公倍数
 * (a,b) : a b之间的最大公约数
 * 最小公倍数 * 最大公约数 = a * b
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-14
 */
public class GCD {
    public static int gcd(int a, int b){
        return b== 0 ? a : gcd(b, a % b) ;
    }

    public static int mcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
    public static void main(String[] args) {
        System.out.println(gcd(24,60));
        System.out.println(mcm(6,15));
    }
}
