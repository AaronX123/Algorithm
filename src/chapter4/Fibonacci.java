package chapter4;

import java.util.Date;

/**
 * 求斐波那契第N项的值
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-07
 */
public class Fibonacci {

    /**
     * 时间复杂度O(2^n)巨慢
     * @param index
     * @return
     */
    public long fibonacci(int index){
        if (index<1){
            return 0;
        }
        if(index==1||index==2){
           return 1;
        }else {
           return fibonacci(index-2)+fibonacci(index-1);
        }
    }

    /**
     * 每次3个3个移动，这样就O(n)
     * @param index
     * @return
     */
    public long fibonacci2(int index){
        if (index < 1){
            return 0;
        }else if (index == 1 || index == 2){
            return 1;
        }else {
            long res = 1;
            long pre = 1;
            long temp = 0;
            for (int i = 3;i < index;i++){
                temp = res;
                res = res + pre;
                pre = temp;

            }
            return res;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Fibonacci fibonacci=new Fibonacci();
        System.out.println(fibonacci.fibonacci2(10000000));
    }
}
