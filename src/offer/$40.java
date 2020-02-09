package offer;

import util.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-05
 */
public class $40 {
    public boolean isBalancedSolution(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
                isBalancedSolution(root.left) && isBalancedSolution(root.right);
    }

    private int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 递归返回时判断左右子树高度差值，如果差值大于1则返回false
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
