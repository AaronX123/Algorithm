package acwing;

/**
 * 输入一个二叉树，将它变换为它的镜像。
 *
 * 样例
 * 输入树：
 *       8
 *      / \
 *     6  10
 *    / \ / \
 *   5  7 9 11
 *
 *  [8,6,10,5,7,9,11,null,null,null,null,null,null,null,null]
 * 输出树：
 *       8
 *      / \
 *     10  6
 *    / \ / \
 *   11 9 7  5
 *
 *  [8,10,6,11,9,7,5,null,null,null,null,null,null,null,null]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 二叉树的镜像 {
    public static void mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode temp = right;
        root.right = left;
        root.left = temp;
        mirror(root.left);
        mirror(root.right);
    }
}
