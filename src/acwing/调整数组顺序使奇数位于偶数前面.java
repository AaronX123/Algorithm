package acwing;

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
    public void reOrderArray(int [] array) {
        // 奇数的位置
        int oddIndex = -1;
        // 偶数的位置
        int evenIndex = -1;

        for (int i = 0; i < array.length; i++) {
            // 是偶数，则不动
            if (array[i] % 2 == 0){
                if (evenIndex == -1){
                    evenIndex = i;
                }
            }else {
                if (evenIndex != -1){
                    int temp = array[i];
                    array[i] = array[evenIndex];
                    array[evenIndex] = temp;
                    evenIndex = i;
                }
            }
        }
    }
}
