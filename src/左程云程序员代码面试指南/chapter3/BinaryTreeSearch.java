package 左程云程序员代码面试指南.chapter3;

import util.TreeNode;

import java.util.Stack;

/**
 * 以递归和非递归形式实现前中后序遍历二叉树
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-06
 */
public class BinaryTreeSearch {
    public TreeNode root = new TreeNode(1,null,null);

    /**
     *       1
     *     /  \
     *    3    9
     *   / \  / \
     *  5  7 11 13
     *
     *    先序遍历 ：1 3 5 7 9 11 13
     *    中序遍历 ：5 3 7 1 11 9 13
     *    后序遍历 ：5 7 3 11 13 9 1
     */
    public void init(){
        root.left = new TreeNode(3,new TreeNode(5,null,null),new TreeNode(7,null,null));
        root.right = new TreeNode(9,new TreeNode(11,null,null),new TreeNode(13,null,null));
    }

    /**
     * 非递归
     */
    public void preOrderSearch(){
        if (root!=null){
            Stack stack = new Stack<TreeNode>();
            stack.push(this.root);
            while (!stack.empty()){
                TreeNode head= (TreeNode) stack.pop();
                System.out.println(head.val);
                if (head.right!=null){
                    stack.push(head.right);
                }
                if (head.left!=null){
                    stack.push(head.left);
                }
            }
        }

    }

    public void midOrderSearch(){
        if (root!=null){
            Stack stack = new Stack<TreeNode>();
            TreeNode head = root;
            while (!stack.empty()|| head!=null){
                if (head!=null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = (TreeNode) stack.pop();
                    System.out.println(head.val);
                    head = head.right;
                }
            }
        }
    }

    public void afterOrderSearch(){
        TreeNode head = root;
        if (head!=null){
            Stack<TreeNode> s1 = new Stack<TreeNode>();
            Stack<TreeNode> s2 = new Stack<TreeNode>();
            s1.push(head);
            while (!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if (head.left!=null){
                    s1.push(head.left);
                }
                if (head.right!=null){
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop().val);
            }
        }

    }
    /**
     * 递归遍历
     * @param root 当前处理的节点
     */
    public void preOrderDfs(TreeNode root){
        if (root!=null){
            System.out.println(root.val);
            preOrderDfs(root.left);
            preOrderDfs(root.right);
        }

    }

    /**
     * 中序遍历
     * @param root 当前处理的节点
     */
    public void midOrderDfs(TreeNode root){
        if (root!=null){
            midOrderDfs(root.left);
            System.out.println(root.val);
            midOrderDfs(root.right);
        }
    }

    /**
     * 后序遍历
     * @param root 当前处理的节点
     */
    public void afterOrderDfs(TreeNode root){
        if (root!=null){
            afterOrderDfs(root.left);
            afterOrderDfs(root.right);
            System.out.println(root.val);
        }
    }
    public void show(){
//        preOrderDfs(this.root);
//        midOrderDfs(this.root);
        afterOrderDfs(this.root);
    }

    public static void main(String[] args) {
        BinaryTreeSearch binaryTreeSearch=new BinaryTreeSearch();
        binaryTreeSearch.init();
        binaryTreeSearch.midOrderSearch();
    }
}
