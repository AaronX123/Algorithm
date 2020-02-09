package offer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-02
 */
public class $31 {
    public static int findGreatestSumOfSubArray(int[] array) {
        // 第二个值为当前子序列最大值下标
        Map<Integer,Integer> maxValueForEachLoop = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int max = array[i];
            int sum = 0;
            int index = i;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                //说明找到新的具有最大值的子序列下标
                if (sum > max){
                    index = j;
                    max = sum;
                }
            }
            maxValueForEachLoop.put(max,index);
        }
        Integer[] maxVals = new Integer[maxValueForEachLoop.keySet().size()];
        maxVals = maxValueForEachLoop.keySet().toArray(maxVals);
        int result = maxVals[0];
        for (Integer val : maxVals) {
            if (val > result){
                result = val;
            }
        }
        return result;
    }

    /**
     *     作者：pgl2011
     *     链接：https://www.nowcoder.com/questionTerminal/459bd355da1549fa8a49e350bf3df484?f=discussion
     *     来源：牛客网
     * @param array
     * @return
     */
    public int findGreatestSumOfSubArray2(int[] array) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            //因为负数加上任何数都会比被加数小，所以直接取sum = array[i]
            if(sum < 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }
            //每一步产生的值都去和最大值比较，如果大于就更新
            if(sum > res) {
                res = sum;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(findGreatestSumOfSubArray(new int[]{-2,-8,-1,-5,-9}));
    }
}
