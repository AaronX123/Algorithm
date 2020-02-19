package 剑指Offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-10
 */
public class $29 {
    public static int MoreThanHalfNum_Solution(int [] array) {

        int[] bins = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            bins[array[i]]++;
        }
        for (int i = 0; i < bins.length; i++) {
            if (bins[i] >= array.length/2){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1}));
    }
}
