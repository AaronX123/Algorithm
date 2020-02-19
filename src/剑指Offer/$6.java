package 剑指Offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-01
 */
public class $6 {
    public static void main(String[] args) {

    }

    /**
     * 暴力解法
     * @param array
     * @return
     */
    public int minNumberInRotateArray1(int [] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[index] > array[i]){
                index = i;
            }
        }
        return array[index];
    }

    /**
     * 旋转数组本身就有一部分是有序的
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low < high){
            if (array[mid = (low + high)/2] < array[high]) {
                low = mid;
            }else if (array[mid = (low + high)/2] == array[high]){
                high--;
            }else {
                high = mid;
            }
        }
        return array[low];
    }
}
