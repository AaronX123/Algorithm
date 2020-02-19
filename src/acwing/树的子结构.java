package acwing;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 *
 * 我们规定空树不是任何树的子结构。
 *
 * 样例
 * 树A：
 *
 *      8
 *     / \
 *    8   7
 *   / \
 *  9   2
 *     / \
 *    4   7
 * 树B：
 *
 *    8
 *   / \
 *  9   2
 * 返回 true ,因为B是A的子结构。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 树的子结构 {
    public static boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null ||pRoot2 == null){
            return false;
        }
        if (isPart(pRoot1,pRoot2)){
            return true;
        }
        return hasSubtree(pRoot1.left,pRoot2) || hasSubtree(pRoot1.right,pRoot2);
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;
        System.out.println(hasSubtree(node1,node2));
    }

//    private boolean hasSubtree0(TreeNode pRoot1, TreeNode pRoot2){
//        if (pRoot1 == null && pRoot2 != null){
//            return false;
//        }
//        if (pRoot2 == null){
//            return true;
//        }
//        boolean ans = true;
//        if (pRoot1.val == pRoot2.val){
//            ans = hasSubtree(pRoot1.left,pRoot2.left);
//            ans &= hasSubtree(pRoot1.right,pRoot2.right);
//        }else {
//            ans = hasSubtree(pRoot1.left,pRoot2);
//            ans |= hasSubtree(pRoot1.right,pRoot2);
//        }
//        return ans;
//    }
}
