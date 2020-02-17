package acwing;

import util.ListNode;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。
 *
 * 样例1
 * 输入：1->2->3->3->4->4->5
 *
 * 输出：1->2->5
 * 样例2
 * 输入：1->1->1->2->3
 *
 * 输出：2->3
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 删除链表中重复的节点 {
    /**
     * 额外添加一个head用于处理1 -> 1- >的情况，这样能够在返回头的时候直接返回head.next
     * @param head
     * @return
     */
    public ListNode deleteDuplication(ListNode head) {
        if(head == null){return null;}
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode temp = tempHead;
        ListNode preTemp = null;
        while (temp != null){
            ListNode last = temp.next;
            while (last != null && temp.val == last.val){
                last = last.next;
            }
            if (preTemp != null && last != temp.next){
                preTemp.next = last;
                temp = last;
            }else {
                preTemp = temp;
                temp = temp.next;
            }
        }
        return tempHead.next;
    }
}
