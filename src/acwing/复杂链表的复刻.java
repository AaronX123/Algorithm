package acwing;

/**
 * 请实现一个函数可以复制一个复杂链表。
 *
 * 在复杂链表中，每个结点除了有一个指针指向下一个结点外，还有一个额外的指针指向链表中的任意结点或者null。
 *
 * 注意：
 *
 * 函数结束后原链表要与输入时保持一致。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-20
 */
public class 复杂链表的复刻 {
    class ListNode {
        int val;
        ListNode next, random;
        ListNode(int x) { this.val = x; }
    };
    public ListNode copyRandomList(ListNode pHead) {
        if(pHead == null) {
            return null;
        }

        ListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            ListNode cloneNode = new ListNode(currentNode.val);
            ListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        ListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            ListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }
}
