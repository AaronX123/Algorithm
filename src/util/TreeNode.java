package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-06
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    public TreeNode(int v, TreeNode left, TreeNode right){
        this.val = v;
        this.left = left;
        this.right = right;
    }
}