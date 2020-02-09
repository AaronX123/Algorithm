package video;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-02
 */
public class $1 {
    /**
     * 将小于等于target的分到左边，大于的分到右边
     * @param array
     * @param target
     * @return
     */
    public static int[] handle(int[] array, int target){
        int left = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= target){
                int temp = array[left+1];
                array[left+1] = array[i];
                array[i] = temp;
                left++;
            }
        }
        return array;
    }

    /**
     * 荷兰国旗问题，将target分层左边小于，中间等于，右边大于
     * @param array
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int[] NetherlandsHandle(int[] array, int target, int left, int right){
        int less = left - 1;
        int more = right + 1;
        int current = left;
        while (current < more){
            if (array[current] < target){
                swap(array,++less,current++);
            }else if (array[current] == target){
                current++;
            }else {
                //此时不知道从右边换回来的数字是大于target还是小于，所以current不变
                swap(array,--more,current);
            }
        }
        return array;
    }

    /**
     * 优化版快速排序，直接完成了等于的部分排序，节约了新的划分次数
     * @param array
     * @param L
     * @param R
     * @return
     */
    public static int[] quickSort(int[] array, int L, int R){
        if (L<R){
            int[] p = parition(array,L,R);
            quickSort(array,L,p[0]-1);
            quickSort(array,p[1]+1,R);
        }
        return array;
    }

    private static int[] parition(int[] array, int left, int right){
        int less = left - 1;
        int more = right;
        int current = left;
        while (current < more){
            if (array[current] < array[right]){
                swap(array,++less,current++);
            }else if (array[current] == array[right]){
                current++;
            }else {
                //此时不知道从右边换回来的数字是大于target还是小于，所以current不变
                swap(array,--more,current);
            }
        }
        swap(array,more,right);
        return new int[] {less+1,more};
    }


    public static void heapInsert(int[] arr,int pos){
        //当新加入的节点如果比父节点大，则交换
        while (arr[(pos - 1)/2] < arr[pos]){
            swap(arr,pos,(pos - 1)/2);
            pos = (pos - 1)/2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize){
        int left = index*2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left] > arr[left + 1] ? left : left + 1;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static int[] heapSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[0];
            arr[0] = arr[arr.length - 1 - i];
            heapify(arr,0,arr.length - 1 - i);
        }
        return result;
    }


    public static void main(String[] args) {
        //System.out.println(Arrays.toString(NetherlandsHandle(new int[] {3,4,5,2,1,6,3},3,0,6)));
        System.out.println(Arrays.toString(heapSort(new int[] {1,4,2,66,7,84,3})));
    }

    public static void swap(int[] array,int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
