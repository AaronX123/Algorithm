package offer;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-05
 */
public class $22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        }
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                arrayList.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return arrayList;
    }
}
