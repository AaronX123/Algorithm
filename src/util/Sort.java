package util;

import java.util.Arrays;

/**
 * 八种排序算法实现
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-24
 */
public class Sort {
    /**
     * 冒泡，每次比较当前最大的，将最大的移动到尾部
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        if (arr.length<=0){
            return new int[]{};
        }
        boolean sorted = false;
        for (int i=0;i<arr.length && !sorted;i++){
            sorted = true;
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    sorted = false;
                }
            }
        }
        return arr;
    }

    /**
     * 每次插入时判断前面是否还有大于自己的
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr){
        if (arr == null || arr.length == 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    // 找前面是否存在比j + 1元素大的
                    int m = j + 1;
                    for (int k = j; k >= 0 ; k--) {
                        if (arr[k] > arr[m]){
                            int t = arr[m];
                            arr[m] = arr[k];
                            arr[k] = t;
                            m = k;
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 每次找出最大的元素，然后和末尾交换
     * @param args
     * @return
     */
    public static int[] selectSort(int[] args){
        if (args == null || args.length == 0){
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < args.length; i++) {
            int max = 0;
            for (int j = 1; j < args.length - i; j++) {
                if (args[max] < args[j]){
                    max = j;
                }
            }
            int temp = args[max];
            args[max] = args[args.length - 1 - i];
            args[args.length - 1 - i] = temp;
        }
        return args;
    }

    /**
     * 两边进行交换，以一个基准将左右两边分开
     * @param arr
     * @return
     */
    public static int[] fastSort(int[] arr){
        partition(arr,0,arr.length - 1);
        return arr;
    }

    private static void partition(int[] arr, int low, int high){
        if (low > high){
            return;
        }
        int pivot = arr[low];
        int left = low;
        int right = high;
        while (left < right){
            while (left < right && arr[right] >= pivot){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        partition(arr,low,left - 1);
        partition(arr,left + 1, high);
    }

    /**
     * 堆排序，就是不断取堆顶元素，然后将数组中最后一个元素插入堆顶进行平衡
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr){
        for (int i = arr.length - 1; i > 0; i--) {
            heapify(arr,i);
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void heapify(int[] arr, int n){
        int child = 0;
        for (int i = (n - 1) / 2; i >= 0 ; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && arr[child] < arr[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (arr[i] < arr[child]) {
                int temp = arr[i];
                arr[i] = arr[child];
                arr[child] = temp;
            }
        }
    }

    public static int[] mergetSort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);
        return temp;
    }
    private static void sort(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }
    }

    /**
     * 基数排序
     * @param arr
     */
    public static int[] radixSort(int[] arr) {

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            base *= 10;
        }

        return arr;
    }

    /**
     * 希尔排序
     * @param a
     */
    public static int[] shellSort(int[] a) {
        int length = a.length;
        int h = 1;
        while (h < length / 3) h = 3 * h + 1;
        for (; h >= 1; h /= 3) {
            for (int i = 0; i < a.length - h; i += h) {
                for (int j = i + h; j > 0; j -= h) {
                    if (a[j] < a[j - h]) {
                        int temp = a[j];
                        a[j] = a[j - h];
                        a[j - h] = temp;
                    }
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,4,5,2,6,7,3,8,9};
        System.out.println(Arrays.toString(mergetSort(array)));
        int a = Integer.MAX_VALUE;

        System.out.println("\0");
    }
}
