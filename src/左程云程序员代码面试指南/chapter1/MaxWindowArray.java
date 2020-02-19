package 左程云程序员代码面试指南.chapter1;

import java.util.Arrays;

/**
 * 有一个整数组arr和一个窗口大小为w的数组，从最左边滑倒最右边，每次滑一个位置，输出长度为n-w+1的数组res，其中每个元素是当前窗口中最大值
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-21
 */
public class MaxWindowArray {
    private int[] arr;
    private int w;
    public int[] getMaxWindowArray(int[] arr,int w){
        if (w > arr.length){
            throw new IllegalArgumentException("窗口大小不能大于数组长度");
        }else {
            int[] res = new int[arr.length-w+1];
            for (int i=0; i<=arr.length-w; i++){
                int temp = i;
                for (int j=i;j<w-1+i;j++){
                    if (arr[temp]<arr[j+1]){
                        temp = j+1;
                    }
                }
                res[i] = arr[temp];
            }
            return res;
        }
    }

    public static void main(String[] args){
        MaxWindowArray array = new MaxWindowArray();
        int[] array2 = {1,2,44,5,68,7,8};
        int res[] =array.getMaxWindowArray(array2,3);
        System.out.println(Arrays.toString(res));
    }
}
