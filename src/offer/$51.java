package offer;

import java.util.Arrays;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-12
 */
public class $51 {
    public boolean duplicate(int[] numbers,int length,int [] duplication) {
        if (numbers == null || numbers.length <= 1 || length <= 1){
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public boolean duplicate2(int[] numbers,int length,int [] duplication){
        for ( int i= 0 ; i<length; i++) {
            int index = numbers[i];
            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] = numbers[index] + length;
        }
        return false ;
    }

    public static void main(String[] args) {
        new $51().duplicate2(new int[]{1,5,3,6,4,6,5},7,new int[1]);
    }
}
