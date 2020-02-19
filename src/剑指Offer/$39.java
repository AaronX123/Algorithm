package 剑指Offer;

import util.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-05
 */
public class $39 {
    public int treeDepth(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int l = dfs(root.left,depth + 1);
        int r = dfs(root.right,depth + 1);
        return Math.max(l,r);
    }
}
