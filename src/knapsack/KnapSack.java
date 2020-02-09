package knapsack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-25
 */
public class KnapSack {
    /**
     * 算出来的二维矩阵，代表各种情况下的最大值
     */
    private int[][] result = new int[6][21];
    /**
     * 价值
     */
    private int[] value = new int[]{3,5,6,7,9,14};
    /**
     * 消耗的空间
     */
    private int[] weight = new int[]{2,3,5,6,8,9};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * 终止输入条件
         */
        String flag = "-1";
//        while (!flag.equals(scanner.next())){
//
//        }
        KnapSack knapSack =new KnapSack();
        knapSack.knapSack();
        System.out.println(knapSack.result[4][20]);
    }
    public void knapSack(){
        /**
         * k为物品，c为当前剩余容量
         */
        int k,c;
        for (k=1;k<result.length;k++){
            for (c=1;c<result[0].length;c++){
                if (weight[k]>c){
                    result[k][c] = result[k-1][c];
                }else {
                    int value1 = result[k-1][c-weight[k]]+value[k];
                    int value2 = result[k-1][c];
                    if (value1 > value2){
                        result[k][c] = value1;
                    }else {
                        result[k][c] = value2;
                    }
                }
            }
        }
    }
}
