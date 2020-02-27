package acwing;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 假设数组非空，并且一定存在满足条件的数字。
 *
 * 思考题：
 *
 * 假设要求只能使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？
 * 样例
 * 输入：[1,2,1,1,3]
 *
 * 输出：1
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-21
 */
public class 数组中出现次数超过一半的数字 {
    public int moreThanHalfNum_Solution(int[] nums) {
        int val = 0, count = 0;
        for (int num : nums) {
            if (count == 0){
                count++;
                val = num;
            }else {
                if (val == num){
                    count++;
                }else {
                    count--;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == val){
                count++;
            }
        }
        return count > nums.length >> 1 ? val : 0;
    }

    public static void main(String[] args) {
        new 数组中出现次数超过一半的数字().moreThanHalfNum_Solution(new int[]{1,2,3,2,4,2,5,2,3});
    }
}
