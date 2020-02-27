package acwing;

import java.util.Arrays;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 您需要确保二叉树可以序列化为字符串，并且可以将此字符串反序列化为原始树结构。
 *
 * 样例
 * 你可以序列化如下的二叉树
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 *
 * 为："[8, 12, 2, null, null, 6, 4, null, null, null, null]"
 * 注意:
 *
 * 以上的格式是AcWing序列化二叉树的方式，你不必一定按照此格式，所以可以设计出一些新的构造方式。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-20
 */
public class 序列化二叉树 {
    /**
     * 返回前序和中序遍历的结果
     * @param root
     * @return
     */
    static String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        inTraversal(root,builder);
        builder.append(",");
        preTraversal(root,builder);
        return builder.toString();
    }

    private static void inTraversal(TreeNode root, StringBuilder builder){
        if (root == null){
            return;
        }
        inTraversal(root.left,builder);
        builder.append(root.val);
        inTraversal(root.right,builder);
    }

    private static void preTraversal(TreeNode root, StringBuilder builder){
        if (root == null){
            return;
        }
        builder.append(root.val);
        inTraversal(root.left,builder);
        inTraversal(root.right,builder);
    }
    /**
     * 中序遍历的重建二叉树
     * @param data
     * @return
     */
    static TreeNode deserialize(String data) {
        if (data == null || "".equals(data)){
            return null;
        }
        String[] orders = data.split(",");
        char[] inOrder = orders[0].toCharArray();
        char[] preOrder = orders[1].toCharArray();
        int[] inOrderInt = new int[inOrder.length];
        int[] preOrderInt = new int[preOrder.length];
        for (int i = 0; i < inOrder.length; i++) {
            inOrderInt[i] = inOrder[i] - '0';
        }
        for (int i = 0; i < preOrder.length; i++) {
            preOrderInt[i] = preOrder[i] - '0';
        }
        return buildTree(preOrderInt,inOrderInt);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0){
            return null;
        }
        // 找到中序遍历头在前序遍历中的位置
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]){
                index = i;
            }
        }

        TreeNode head = new TreeNode(preorder[0]);
        head.left = buildTree(Arrays.copyOfRange(preorder,1,index + 1),Arrays.copyOfRange(inorder,0,index));
        head.right = buildTree(Arrays.copyOfRange(preorder,index + 1,preorder.length), Arrays.copyOfRange(inorder,index + 1,inorder.length));
        return head;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 =new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        node6.right = node8;
        node8.left = node7;
        System.out.println(serialize(node5));
        System.out.println(serialize(deserialize(serialize(node5))));
        ;
    }
}
