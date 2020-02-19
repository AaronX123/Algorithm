package 剑指Offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-06
 */
public class $43 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        // sum 小于最小的两个数之和， sum大于最大的2个数之和
        if (array == null || array.length < 2
                || sum < array[0] + array[1]
                || sum > array[array.length-1] + array[array.length - 2]){
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int bigger = 0;
        for (int i = 0; i < array.length; i++) {
            start = array[i];
            if (start >= sum / 2){
                break;
            }
            for (int j = i + 1; j < array.length; j++) {
                bigger = array[j];
                if (start + bigger == sum){
                    if (result.size() == 0 || result.get(0) * result.get(1) > start * bigger){
                        result.add(0,start);
                        result.add(1,bigger);
                    }
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindNumbersWithSum(new int[]{1,2,3,4,5,6,7,8,9},12);
    }
}
