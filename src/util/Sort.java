package util;

import java.util.Arrays;

/**
 * 八种排序算法实现
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-24
 */
public class Sort {
    /**
     * 优化版本
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        if (arr.length<=0){
            return new int[]{};
        }
        boolean sorted = false;
        for (int i=0;i<arr.length && !sorted;i++){
            sorted = true;
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    sorted = false;
                }
            }
        }
        return arr;
    }

//    public static int[] selectSort(int[] arr){
//
//    }
    public static int get(int a){
        return a;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,4,5,2,6,7,3,8,9};
        System.out.println(Arrays.toString(bubbleSort(array)));
        int a = Integer.MAX_VALUE;

        System.out.println("\0");
    }
}
