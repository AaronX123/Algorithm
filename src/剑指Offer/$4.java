package 剑指Offer;

import util.TreeNode;

import java.util.Arrays;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-01
 */
public class $4 {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0){
            return null;
        }
        if (pre.length == 1){
            return new TreeNode(pre[0]);
        }

        int rootValue = pre[0];
        //root所在的个数恰好对应前序遍历的左子树
        int rootIndex = 0;
        //确定root在中序遍历过程中的位置，左边为root的左子树,右边为root的右子树

        for(int i=0;i<in.length;i++){
            if(rootValue == in[i]){
                rootIndex = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        //因为第0个元素是root，所以从1开始分割，rootIndex恰好表示左子树个数因为i从0开始
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex+1),Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex+1,pre.length),Arrays.copyOfRange(in,rootIndex+1,in.length));
        return root;
    }
}
