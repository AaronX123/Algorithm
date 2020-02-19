package 剑指Offer;

import util.ListNode;

import java.util.Stack;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-04
 */
public class $37 {
    /**
     * 对于有着公共部分的单链表来说，最后一定会是相同的元素，因此用2个栈来存储2条链表的元素。
     * 直接比较栈顶，如果栈顶元素一开始就不一致则说明没有公共节点，如果栈顶一致，则pop出相同的元素并记录下来，然后
     * 继续比较栈顶，直到找到第一个公共节点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }

        ListNode commonListNode = null;

        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek() ) {
            stack2.pop();
            commonListNode = stack1.pop();;
        }

        return commonListNode;

    }

    /**
     * 链表1 为a+n长度，链表2 为b+n长度，设a < b，p1首先走链表1，p2首先走链表2，
     * 当p1走完时路程为a+n，此时p2的位置是(b + n) - (a + n) = b - a
     * 此时将p1 = pHead2，继续走，当p2走完时走了 b - a 的距离时此时p1的位置是(b + n) - (b - a) = a + n
     * p2 = pHead1，此时p2的路程还有 a + n，则以相同速度p1 必然会和 p2相遇
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode indFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2){
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }

        return p1;
    }
}
