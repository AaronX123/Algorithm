package offer;

import util.ListNode;

import java.util.ArrayList;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-03
 */
public class $14 {
    /**
     * 快慢指针，慢指针始终比快指针少K步，当快指针到达尾部时，就意味着慢指针指向的是倒数第K个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode fastPoint = head;
        ListNode slowPoint = head;
        int index = 0;
        while (fastPoint != null){
            if (index >= k){
                slowPoint = slowPoint.next;
            }
            fastPoint = fastPoint.next;
            index++;

        }
        return index < k ? null : slowPoint;
    }
    /**
     * 链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a
     * 来源：牛客网
     */
    public ListNode FindKthToTail3(ListNode head,int k) { //5,{1,2,3,4,5}
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }

    /**
     * 常规做法，先求出长度，再取到节点
     * @param list
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode list,int k) {
        if (list == null)   return list;

        ListNode node = list;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        if (count < k)  return null;

        ListNode p = list;
        for (int i = 0; i < count - k; i++) {
            p = p.next;
        }

        return p;
    }
}
