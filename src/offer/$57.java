package offer;

import util.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-13
 */
public class $57 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        ListNode h = new ListNode(0);
        ListNode pre = h;
        h.next = pHead;
        ListNode last = h.next;
        while (last != null){
            // 如果发现出现一样的元素，则找到该值的最后一个相同的元素
            if (last.next != null && last.val == last.next.val){
                while (last.next != null && last.val == last.next.val){
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            }else {
                pre = pre.next;
                last = last.next;
            }
        }
        return h.next;
    }
}
