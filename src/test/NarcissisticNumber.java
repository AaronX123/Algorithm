package test;

import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-17
 */
public class NarcissisticNumber {
    private static int n = 0;
    private static int m = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            m = scanner.nextInt();
            n = scanner.nextInt();
            solve();
        }
    }
    public static void solve(){
        if (m>n){
            throw new IllegalArgumentException();
        }
        //int范围不能超过10位
        int[] byteNumber = new int[10];
        char[] number = Integer.valueOf(m).toString().toCharArray();
        byteNumber[0] = number[number.length-1];
        for (int i=1;i<byteNumber.length;i++){
            byteNumber[i] = m%(10*i);
        }
    }
}
