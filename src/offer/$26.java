package offer;

import util.TreeNode;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-10
 */
public class $26 {

    public static TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }
    public static void main(String[] args) {
        TreeNode bstRoot = new TreeNode(5);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(1);
        TreeNode left1Right1 = new TreeNode(4);
        TreeNode right = new TreeNode(7);
        bstRoot.left = left1;
        bstRoot.right = right;
        left1.left = left2;
        left1.right = left1Right1;

        Convert(bstRoot);
    }
}
