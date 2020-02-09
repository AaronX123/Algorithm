package offer;

import util.TreeNode;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-04
 */
public class $17 {
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    public static boolean isSubTree(TreeNode root1, TreeNode root2){
        if (root1 == null ){
            return false;
        }
        if (root2 == null){
            return true;
        }
        if (root1.val == root2.val){
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right, root2.right);
        }
        return false;
    }
}
