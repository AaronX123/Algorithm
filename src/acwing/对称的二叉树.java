package acwing;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 *
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 样例
 * 如下图所示二叉树[1,2,2,3,4,4,3,null,null,null,null,null,null,null,null]为对称二叉树：
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 如下图所示二叉树[1,2,2,null,4,4,3,null,null,null,null,null,null]不是对称二叉树：
 *     1
 *    / \
 *   2   2
 *    \ / \
 *    4 4  3
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return isSymmetric0(root.left,root.right);
    }

    private boolean isSymmetric0(TreeNode p1, TreeNode p2){
        if (p1 == null && p2 == null){
            return true;
        }
        if (p1 == null || p2 == null){
            return false;
        }
        return p1.val == p2.val && isSymmetric0(p1.left,p2.right) && isSymmetric0(p1.right,p2.left);
    }
}
