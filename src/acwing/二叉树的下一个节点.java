package acwing;


/**
 * 给定一棵二叉树的其中一个节点，请找出中序遍历序列的下一个节点。
 *
 * 注意：
 *
 * 如果给定的节点是中序遍历序列的最后一个，则返回空节点;
 * 二叉树一定不为空，且给定的节点一定不是空节点；
 * 样例
 * 假定二叉树是：[2, 1, 3, null, null, null, null]， 给出的是值等于2的节点。
 *
 * 则应返回值等于3的节点。
 *
 * 解释：该二叉树的结构如下，2的后继节点是3。
 *   2
 *  / \
 * 1   3
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-16
 */
public class 二叉树的下一个节点 {
    public TreeNode inorderSuccessor(TreeNode p) {
        if (p == null){
            return null;
        }
        // 如果当前节点如果有右子树，则下一个中序遍历的节点就是右子树最左叶节点
        if (p.right != null){
            TreeNode temp = p.right;
            while (temp != null){
                temp = temp.left;
            }
            return temp;
        }
        while(p.father !=null){
            if(p.father.left==p) {
                return p.father;
            }
            p=p.father;
        }
        return null;
    }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode father;
  TreeNode(int x) { val = x; }
}