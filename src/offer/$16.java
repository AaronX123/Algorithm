package offer;

import util.ListNode;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-03
 */
public class $16 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1,new ListNode(3,new ListNode(5,new ListNode(7))));
        ListNode n2 = new ListNode(2,new ListNode(4,new ListNode(6)));
        ListNode n3 = Merge(n1,n2);
        while (n3!=null){
            System.out.print(n3);
            n3 = n3.next;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode newNode = list1.val <= list2.val ? list1 : list2;
        if (newNode == list1){
            list1 = list1.next;
        }else {
            list2 = list2.next;
        }
        ListNode current = newNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val){
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }
        if (list1 == null){
            current.next = list2;
        }else {
            current.next = list1;
        }
        return newNode;
    }

    public ListNode Merge2(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
    }
}
