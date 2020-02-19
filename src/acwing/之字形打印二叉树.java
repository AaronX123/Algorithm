package acwing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序从上向下打印二叉树。
 *
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * 样例
 * 输入如下图所示二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]
 *     8
 *    / \
 *   12  2
 *      / \
 *     6   4
 * 输出：[[8], [2, 12], [6, 4]]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 之字形打印二叉树 {
    class NodeHolder{
        TreeNode node;
        int layer;

        public NodeHolder(TreeNode node, int layer) {
            this.node = node;
            this.layer = layer;
        }

        @Override
        public String toString() {
            return "NodeHolder{" +
                    "node=" + node +
                    ", layer=" + layer +
                    '}';
        }
    }
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        ArrayList<NodeHolder> list = new ArrayList<>();
        Queue<NodeHolder> queue = new LinkedList<>();
        queue.add(new NodeHolder(root,0));
        while (!queue.isEmpty()){
            NodeHolder holder = queue.poll();
            list.add(holder);
            if (holder.node.left != null){
                queue.add(new NodeHolder(holder.node.left,holder.layer + 1));
            }
            if (holder.node.right != null){
                queue.add(new NodeHolder(holder.node.right,holder.layer + 1));
            }
        }
        // list的最后一个元素的layer属性就是高度
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= list.get(list.size() - 1).layer; i ++){
            List<Integer> temp = new ArrayList<>();
            // 右到左打印
            if (i % 2 == 1){
                for (int j = list.size() - 1; j >= 0; j--) {
                    if (list.get(j).layer == i){
                        temp.add(list.get(j).node.val);
                        list.get(j).layer = -1;
                    }
                }
            }else {
                for (int j = 0; j < list.size(); j++){
                    if (list.get(j).layer == i){
                        temp.add(list.get(j).node.val);
                        list.get(j).layer = -1;
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }

}
