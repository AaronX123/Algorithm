package 剑指Offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-05
 */
public class $38 {
    /**
     * 时间复杂度 O(n),空间复杂度O(1)
     * @param array
     * @param k
     * @return
     */
    public int getNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k){
                count++;
            }
        }
        return count;
    }

    /**
     * 通过二分法找到这个数，然后向前找到第一次出现的位置，向后找到最后出现的位置。
     * @param arr
     * @param k
     * @return
     */
    public int getNumberOfK2(int[] arr, int k){
        int count = 0;
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (arr[mid] == k){
                break;
            }
            if (arr[mid] < k){
                low = mid + 1;
            }
            if (arr[mid] > k){
                high = mid - 1;
            }
        }
        if (low <= high){
            for (int i = mid; i >= 0; i--){
                if (arr[i] == k){
                    count++;
                }else {
                    break;
                }
            }
            for (int i = mid + 1; i < arr.length; i++){
                if (arr[i] == k){
                    count++;
                }else {
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 直接找前一个数字和后一个数字的位置，然后相减得到
     * 0 1 2 3 4 5 7 7 8 9 10
     * @param array
     * @param k
     * @return
     */
    public int getNumberOfK3(int [] array , int k) {
        if(array == null || array.length == 0)
            return 0;
        return binSearch(array, k + 0.5) - binSearch(array, k - 0.5);
    }
//
    private int binSearch(int[] arr, double n){
        int low =0, mid = 0, high = arr.length - 1;
        while (low <= high){
            mid = low + (high - low) / 2;
            if (arr[mid] > n){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

}
