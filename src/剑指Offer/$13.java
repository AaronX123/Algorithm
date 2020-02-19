package 剑指Offer;

import java.util.Arrays;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-03
 */
public class $13 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void reOrderArray(int [] array) {
        int left = -1;
        for (int i = 0; i < array.length; i++) {
            if (isOdd(array[i])){
                //先保存奇数，然后将奇数到left中间的偶数全部后移
                int temp = array[i];
                //将偶数全部后移
                for (int j = i - 1; j > left; j--){
                    array[j + 1] = array[j];
                }
                //放置奇数
                array[left + 1] = temp;
                left++;
            }
        }
    }
    public static boolean isOdd(int num){
        return num % 2 == 1;
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
