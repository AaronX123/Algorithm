package offer;

import util.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-12
 */
public class $56 {
    /**
     * pA和pB,2vpA = vpB;当pA 和 pB 相遇时说明遇到环。然后将pA置到链表头，然后va = vb，再次相遇就是第一个交点
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast=pHead;
        ListNode low=pHead;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low)
                break;
        }
        if(fast==null||fast.next==null)
            return null;
        low=pHead;
        while(fast!=low){
            fast=fast.next;
            low=low.next;
        }
        return low;
    }
}
