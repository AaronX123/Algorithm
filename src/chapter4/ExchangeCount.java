package chapter4;

/**
 * 换钱的最小货币数
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-23
 */
public class ExchangeCount {
    public int exchange(int[] arr,int aim){
        if (arr == null || aim <0){
            return 0;
        }else {
            while (true){
                int max = findMax(arr);
                int cost = aim/max;
                int remain = aim % max;
                int index = exists(arr,remain);
                if (index!=-1){
                    cost++;
                    return cost;
                }
                if (remain == 0){
                    return cost;
                }
            }
        }
    }

    private int findMax(int[] arr){
        int temp = 0;
        for (int i = 0; i<arr.length;i++){
            if (arr[temp]<arr[i]){
                temp = i;
            }
        }
        return arr[temp];
    }
    private int exists(int[] arr, int a){
        for (int i=0;i<arr.length;i++){
            if (arr[i]==a){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ExchangeCount count = new ExchangeCount();
        int arr[] = new int[]{1,2,5,10};
        System.out.println(count.exchange(arr,13));
    }
}
