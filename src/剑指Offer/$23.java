package 剑指Offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-05
 */
public class $23 {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if ( sequence==null || sequence.length<=0 ) {
            return false;
        }
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }

    private static boolean VerifySquenceOfBST(int [] sequence, int start, int end){
        if ( start>end ) {
            return true;
        }
        int root = sequence[end];

        int i=start;//遍历数组，找到右子树的值，将数组分为左子树，右子树两部分。
        while( sequence[i] < root ){
            i++;
        }

        int j=i;//遍历右子树，如果右子树序列中有比root小的元素说明该序列不可能是二叉排序树
        while( j<end ){
            if ( sequence[j]<root ) {
                return false;
            }
            j++;
        }
        //将左子树和右子树递归，进一步判断他们是不是二叉排序树
        boolean left = VerifySquenceOfBST(sequence, start, i-1);
        boolean right = VerifySquenceOfBST(sequence, i, end-1);
        return left && right;//返回与结果
    }
    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{4,8,6,11,14,12,10}));
    }
}
