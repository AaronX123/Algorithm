package acwing;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *
 * 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * 样例
 * 给出二叉树如下所示，并给出num=22。
 *       5
 *      / \
 *     4   6
 *    /   / \
 *   12  13  6
 *  /  \    / \
 * 9    1  5   1
 *
 * 输出：[[5,4,12,1],[5,6,6,5]]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 二叉树中和为某一值的路径 {
    private ArrayList<List<Integer>> listAll = new ArrayList<List<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();
    public List<List<Integer>> findPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size()-1);
        return listAll;
    }

}
