package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-05
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(){}

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "label=" + val +
                ", next=" + next +
                '}';
    }
}
