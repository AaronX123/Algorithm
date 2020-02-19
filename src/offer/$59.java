package offer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-14
 */
public class $59 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return left.val == right.val //为镜像的条件：左右节点值相等
                && isSymmetrical(left.left, right.right) //2.对称的子树也是镜像
                && isSymmetrical(left.right, right.left);
    }

    boolean isSymmetricalDFS(TreeNode pRoot) {
        if(pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while(!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if(left == null && right == null) continue;
            if(left == null || right == null) return false;
            if(left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }
}
