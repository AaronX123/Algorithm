package offer;

import util.TreeNode;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-04
 */
public class $18 {
    public static void Mirror(TreeNode root) {
        swapLeftAndRight(root);
    }

    public static void swapLeftAndRight(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = right;
        root.right = left;
        root.left = temp;
        swapLeftAndRight(root.left);
        swapLeftAndRight(root.right);
    }
}
