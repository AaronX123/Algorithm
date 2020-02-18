package acwing;

import util.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 注意：
 *
 * k >= 0;
 * 如果k大于链表长度，则返回 NULL;
 * 样例
 * 输入：链表：1->2->3->4->5 ，k=2
 *
 * 输出：4
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-18
 */
public class 链表中倒数第k个节点 {
    public ListNode findKthToTail(ListNode pListHead, int k) {
        int count = 0;
        if (pListHead == null){
            return null;
        }
        ListNode head = pListHead;
        while (head != null){
            head = head.next;
            count++;
        }
        if (count < k){
            return null;
        }
        count -= k;
        head = pListHead;
        while (count > 0){
            head = head.next;
            count--;
        }
        return head;
    }

}
