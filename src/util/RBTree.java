package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-25
 */
public class RBTree {
    class RBTreeNode{
        boolean red;
        int val;
        RBTreeNode left;
        RBTreeNode right;
        RBTreeNode parent;

        public RBTreeNode(int val, RBTreeNode parent) {
            red = true;
            this.val = val;
            this.parent = parent;
        }

        public RBTreeNode(int val, RBTreeNode left, RBTreeNode right, RBTreeNode parent) {
            this.red = true;
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public RBTreeNode(boolean red, int val, RBTreeNode left, RBTreeNode right, RBTreeNode parent) {
            this.red = red;
            this.val = val;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }

    public RBTree(){

    }

    /**
     * 当前节点的父节点和叔叔节点都红时，将父节点和叔叔节点染成黑色，祖父节点，叶节点染成红色，
     * 然后判断祖父节点的父节点是否为红色
     * @param root
     * @param val
     * @return
     */
    public RBTreeNode insert(RBTreeNode root, int val){
        if (root == null){
            return new RBTreeNode(val,root);
        }
        RBTreeNode p = search(root,val);
        RBTreeNode g = p.parent;
        if (g == null){
            if (p.val < val){
                p.right = new RBTreeNode(val,p);
            }else if (p.val > val){
                p.left = new RBTreeNode(val,p);
            }else {
                // 和p一致不操作
            }
        }else {
            if (p.red){

            }
        }
        return p;
    }

    private RBTreeNode rotateRight(RBTreeNode root){
        RBTreeNode c = root.left;
        c.right = root.left;
        c.parent = root.parent;
        root.parent = c;
        return c;
    }

    private RBTreeNode rotateLeft(RBTreeNode root){
        return rotateRight(root);
    }
    /**
     * 如果不存在则返回当前的节点
     * @param root
     * @param val
     * @return
     */
    public RBTreeNode search(RBTreeNode root, int val){
        if (root == null){
            return null;
        }
        if (root.val == val){
            return root;
        }
        if (root.val < val && root.left != null){
            return search(root.left,val);
        }else if (root.val > val && root.right != null){
            return search(root.right,val);
        }else { // 未查找到就返回叶节点
            return root;
        }
    }
}
