package acwing;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 注意：
 *
 * 需要返回双向链表最左侧的节点。
 * 例如，输入下图中左边的二叉搜索树，则输出右边的排序双向链表。
 *
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-20
 */
public class 二叉搜索树与双向链表 {
    public TreeNode convert(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode head = convert0(root);
        while(head.left != null){
            head = head.left;
        }
        return head;
    }

    private TreeNode convert0(TreeNode root){
        if (root == null){
            return null;
        }
        // 对于左子树来说需要连接到左子树最右边节点
        if (root.left != null){
            TreeNode left = convert0(root.left);
            while (left.right != null){
                left = left.right;
            }
            root.left = left;
            left.right = root;
        }
        // 对于右子树来说需要连接到右子树最左边节点
        if (root.right != null){
            TreeNode right = convert0(root.right);
            while (right.left != null){
                right = right.left;
            }
            right.left = root;
            root.right = right;
        }
        return root;
    }
}
