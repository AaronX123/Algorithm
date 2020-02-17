package acwing;

import util.TreeNode;

import java.util.Arrays;

/**
 * 输入一棵二叉树前序遍历和中序遍历的结果，请重建该二叉树。
 *
 * 注意:
 *
 * 二叉树中每个节点的值都互不相同；
 * 输入的前序遍历和中序遍历一定合法；
 * 样例
 * 给定：
 * 前序遍历是：[3, 9, 20, 15, 7]
 * 中序遍历是：[9, 3, 15, 20, 7]
 *
 * 返回：[3, 9, 20, null, null, 15, 7, null, null, null, null]
 * 返回的二叉树如下所示：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-16
 */
public class 重建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0){
            return null;
        }
        // 找到中序遍历头在前序遍历中的位置
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]){
                index = i;
            }
        }

        TreeNode head = new TreeNode(preorder[0]);
        head.left = buildTree(Arrays.copyOfRange(preorder,1,index + 1),Arrays.copyOfRange(inorder,0,index));
        head.right = buildTree(Arrays.copyOfRange(preorder,index + 1,preorder.length), Arrays.copyOfRange(inorder,index + 1,inorder.length));
        return head;
    }


}
