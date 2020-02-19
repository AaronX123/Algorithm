package 剑指Offer;

import util.TreeNode;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-04
 */
public class $17 {
    public static boolean HasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null || pRoot2 == null){
            return false;
        }
        if (isPart(pRoot1,pRoot2)){
            return true;
        }
        return HasSubtree(pRoot1.left,pRoot2) || HasSubtree(pRoot1.right,pRoot2);
    }

    private static boolean isPart(TreeNode p1, TreeNode p2){
        if (p2 == null){
            return true;
        }
        if (p1 == null || p1.val != p2.val){
            return false;
        }

        return isPart(p1.left,p2.left) && isPart(p1.right,p2.right);
    }
}
