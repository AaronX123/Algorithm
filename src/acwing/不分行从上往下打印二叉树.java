package acwing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 *
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, null, 4, null, null, null]
 *     8
 *    / \
 *   12  2
 *      /
 *     6
 *    /
 *   4
 *
 * 输出：[8, 12, 2, 6, 4]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 不分行从上往下打印二叉树 {
    public List<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            nodeList.add(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
        return nodeList.stream().map((n) -> n.val).collect(Collectors.toList());
    }
}
