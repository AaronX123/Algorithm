package acwing;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 斐波那契数列 {
    public static int Fibonacci(int n) {
        int a = 0, b = 1;
        while (n -- > 0) {
            int c = a + b;
            a = b; b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(39));
    }

}
