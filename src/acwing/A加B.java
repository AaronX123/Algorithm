package acwing;

import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-15
 */
public class A加B {
    public static int add(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(add(scanner.nextInt(),scanner.nextInt()));
        scanner.close();
    }
}
