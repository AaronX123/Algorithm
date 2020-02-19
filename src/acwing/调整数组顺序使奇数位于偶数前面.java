package acwing;

import static offer.$13.isOdd;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序。
 *
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 *
 * 样例
 * 输入：[1,2,3,4,5]
 *
 * 输出: [1,3,5,2,4]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-18
 */
public class 调整数组顺序使奇数位于偶数前面 {
    /**
     *
     * @param array
     */
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

}
