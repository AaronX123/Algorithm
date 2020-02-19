package acwing;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 *
 * 如果是则返回true，否则返回false。
 *
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * 样例
 * 输入：[4, 8, 6, 12, 16, 14, 10]
 *
 * 输出：true
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 二叉搜索树的后序遍历序列 {
    public boolean verifySequenceOfBST(int [] sequence) {
        if ( sequence==null || sequence.length<=0 ) return true;
        return verifySquenceOfBST0(sequence, 0, sequence.length-1);
    }
    private boolean verifySquenceOfBST0(int [] sequence, int start, int end){
        if ( start>end )
            return true;

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
        return verifySquenceOfBST0(sequence, start, i-1) && verifySquenceOfBST0(sequence, i, end-1);
    }

}
