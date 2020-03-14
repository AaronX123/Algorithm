package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-13
 */
public class 数学知识 {
    boolean isPrime(int x){
        if (x < 2) return false;
        for (int i = 2; i < x / i; i++) {
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 分解质因素
     * @param x
     */
    void divide(int x){
        for (int i = 2; i <= x/i; i++){
            if (x % i == 0){
                int s = 0;
                while (x % i == 0) {
                    x /= i;
                }
                s++;
                System.out.println(i);
                System.out.println(s);
            }
        }
        if (x > 1){
            System.out.println(x+" 1");
        }
    }

    /**
     * 求最大公约数
     * @param a
     * @param b
     * @return
     */
    int gcd(int a, int b){
        return b != 0 ? gcd(b,a % b) : a;
    }

    /**
     * 最小公倍数 = a * b / 最大公约数
     * @param a
     * @param b
     * @return
     */
    int lcm(int a, int b){
        return a * b / gcd(a, b);
    }

    /**
     * 快速幂
     * @param base
     * @param exp
     * @return
     */
    int fastPower(int base, int exp){
        int res = 1;
        int base2 = base;
        while (exp != 0){
            if ((exp & 1) != 0){
                res = res * base2;
            }
            base2 *=  base2;
            exp >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 数学知识().fastPower(2,5));
    }
}
