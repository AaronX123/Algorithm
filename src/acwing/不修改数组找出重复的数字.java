package acwing;

/**
 * 给定一个长度为 n+1 的数组nums，数组中所有的数均在 1∼n 的范围内，其中 n≥1。
 *
 * 请找出数组中任意一个重复的数，但不能修改输入的数组。
 *
 * 样例
 * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。
 *
 * 返回 2 或 3。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-16
 */
public class 不修改数组找出重复的数字 {
    public int duplicateInArray(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }
        // 采用二分思想，n/2个区间内一定会有个数超过n/2的，则重复的数字就在那个区间内
        // 区间是指 数的取值范围，而不是 数组下标
        int l = 1; int r = nums.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++){
                if (nums[i] >= l && nums[i] <= mid){
                    count++;
                }
            }
            if (count > mid - l + 1){
                r = mid;
            }else {
                l = mid +1;
            }
        }
        return r;
    }
}
