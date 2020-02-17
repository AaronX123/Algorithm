package offer;

import util.TreeLinkNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-13
 */
public class $58 {
    List<TreeLinkNode> linkNodes = new ArrayList<>();
    /**
     * 给定的节点是这个树中的一个节点，可以通过next属性找到树的root
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode head = null;
        if (pNode == null){
            return null;
        }
        TreeLinkNode temp = pNode;
        // 去找头
        while (temp.next != null){
            temp = temp.next;
        }
        head = temp;
        inSearch(head);
        for (int i = 0; i < linkNodes.size() - 1; i++) {
            if (linkNodes.get(i).val == pNode.val){
                return linkNodes.get(i + 1);
            }
        }
        return null;
    }

    private void inSearch(TreeLinkNode node){
        if (node == null){
            return;
        }
        inSearch(node.left);
        linkNodes.add(node);
        inSearch(node.right);
    }

    public TreeLinkNode GetNext2(TreeLinkNode p) {
        if (p == null){
            return null;
        }
        // 如果当前节点如果有右子树，则下一个中序遍历的节点就是右子树最左叶节点
        if (p.right != null){
            TreeLinkNode temp = p.right;
            while (temp.left != null){
                temp = temp.left;
            }
            return temp;
        }
        while(p.next !=null){
            if(p.next.left==p){
                return p.next;
            }
            p=p.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        node2.right = node3;
        node3.next = node2;
        node3.right = node4;
        node4.next = node3;
        node4.right = node5;
        node5.next = node4;
        new $58().GetNext2(node5);
    }

//    class Solution {
//        public:
//        TreeLinkNode* GetNext(TreeLinkNode* x){
//            if(!x){return nullptr;}
//            // （1）当x有右儿子：y为x的右子树的最左边结点
//            if(x->right){
//                TreeLinkNode* leftSubtree = x->right;
//                while(leftSubtree->left){
//                    leftSubtree = leftSubtree->left;
//                }
//                return leftSubtree;
//            }
//            // （2）当x无右儿子：
//            else{
//                TreeLinkNode* father = x->next;
//                // 父结点为空，则x为树的头结点，且没有右子树，所以中序的下一结点为空
//                if(!father){return nullptr;}
//                // a. x是x的父结点的左儿子：y为x的父结点
//                else if(father->left == x){
//                    return father;
//                }
//                // b. x是x的父结点的右儿子：
//                else if(father->right == x){
//                    TreeLinkNode* grandpa = father->next;
//                    // 父结点是树的头结点时
//                    if(!grandpa){return nullptr;}
//                    // <1>若父结点是爷结点的左儿子：y为x的爷结点
//                    if(grandpa->left == father){
//                        return grandpa;
//                    }
//                    // <2>否则为NULL，到达树的中序遍历的末尾
//                    else{
//                        return nullptr;
//                    }
//                }//else if
//            }//else
//        }//GetNext()
//    };
}
