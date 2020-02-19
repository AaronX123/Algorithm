package acwing;

import util.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 *
 * 样例
 * 输入：1->3->5 , 2->4->5
 *
 * 输出：1->2->3->4->5->5
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 合并两个排序的链表 {
    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode t = null;
        if (l1.val >= l2.val){
            t = l2;
            l2 = l2.next;
        }else {
            t = l1;
            l1 = l1.next;
        }
        ListNode head = t;
        while (l1 != null && l2 != null){
            if (l1.val >= l2.val){
                t.next = l2;
                l2 = l2.next;
            }else {
                t.next = l1;
                l1 = l1.next;
            }
            t = t.next;
        }
        if (l1 == null){
            t.next = l2;
        }
        if (l2 == null){
            t.next = l1;
        }
        return head;
    }
}
