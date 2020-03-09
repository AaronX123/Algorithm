package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-25
 */
public class RBTree {
    /**
     * 根节点
     */
    RBTreeNode root;

    static class RBTreeNode{
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

    private void rebalance(RBTreeNode node){
        RBTreeNode child = node;
        RBTreeNode parent = child.parent;
        RBTreeNode grandParent = parent == null ? null : parent.parent;

        // 父节点为空那么自己就是根节点
        if (parent == null){
            root = child;
            root.red = false;
            return;
        }
        if (grandParent == null){
            root = parent;
            root.red = false;
            child.red = true;
            return;
        }
        // 如果父节点为黑则直接返回
        if (!parent.red){
            return;
        }
        RBTreeNode uncle = isLeftChild(grandParent,parent) ? grandParent.right : grandParent.left;
        // 如果叔叔节点为红色，直接调整颜色
        if (uncle != null && uncle.red){
            parent.red = false;
            uncle.red = false;
            grandParent.red = true;
            // 再判断下祖父节点的父节点是否为红色，如果为红色则递归
            if (grandParent.parent != null && grandParent.parent.red){
                rebalance(grandParent);
            }
        }else {
            // 叔叔节点不存在或者为黑色，则直接旋转
            RBTreeNode n = parent;
            if (isLeftChild(grandParent,parent)){
                // 判断下自己是否和父亲和祖父在同一直线上
                if (!isLeftChild(parent,child)){
                    // 先把父亲转成左孩子，自己变到父亲的位置上，就变成自己和父亲和祖父在同一直线上的情况了
                    rotateLeft(parent,child);
                    n = child;
                }
                rotateRight(grandParent,n);
            }else {
                if (isLeftChild(parent,child)){
                    rotateRight(child,parent);
                    n = child;
                }
                rotateLeft(grandParent,n);
            }
            grandParent.red = true;
            n.red = false;
            // 如果是根节点就置为黑
            if (root == grandParent){
                grandParent.red = false;
            }
        }
    }

    private boolean isLeftChild(RBTreeNode parent, RBTreeNode child){
        return parent.left == child;
    }

    private void rotateRight(RBTreeNode node, RBTreeNode center){
        if (center.parent == node){
            center.parent = node.parent;
            node.parent = center;
            node.left = center.right;
            center.right = node;
        }else {
            node.parent = center.parent;
            center.parent = node;
            node.right = center;
        }
    }

    private void rotateLeft(RBTreeNode node, RBTreeNode center){
        if (center.parent == node){
            center.parent = node.parent;
            node.parent = center;
            node.right = center.left;
            center.left = node;
        }else {
            node.parent = center.parent;
            center.parent = node;
            node.left = center;
        }
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

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }

    static final int tableSizeFor2(int cap){
        int i = 0;
        while (cap != 0){
            cap >>= 1;
            i++;
        }
        return 1 << i;
    }

    public static void main(String[] args) {

        System.out.println(tableSizeFor2(9));
    }
}
