package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-02
 */
public class $30 {
    /**
     * 采用选择排序的思路，循环k次，每次从i位置寻找右边最小的数字并交换，最后输出数字前k个元素
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> getLeastNumbersSolution(int [] input, int k) {
        if (input == null || input.length < k){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < k; i++) {
            //找出当前最小的下标
            int min = i;
            for (int j = i + 1; j < input.length; j++){
                if (input[min] > input[j]){
                    min = j;
                }
            }
            //做一次交换
            int temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        List list = getLeastNumbersSolution(new int[]{1,5,3,5,6,3},3);
        list.forEach(System.out::println);
    }
}
