package offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-04
 */
public class $36 {


    public static int InversePairs(int [] array) {
        int count = 0;
        int pre = array[0];
        for(int i = 1;i < array.length; i++){
            if (pre > array[i]){
                count++;
            }
            pre = array[i];
        }
        return count % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(InversePairs(new int[]{1,2,3,4,5,6,7,0}));
    }
}
