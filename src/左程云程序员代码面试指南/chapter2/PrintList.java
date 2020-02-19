package 左程云程序员代码面试指南.chapter2;

import util.ListNode;

/**
 * 打印两个有序链表的公共部分
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-05
 */
public class PrintList {
    private ListNode head1 = new ListNode(1,null);
    private ListNode head2 = new ListNode(2,null);

    public void init(){
        head1.next=new ListNode(1,
                new ListNode(2,
                        new ListNode(3,new ListNode(4,
                                new ListNode(5,
                                        new ListNode(7,null))
                        ))));
        head2.next=new ListNode(1,
                new ListNode(2,
                        new ListNode(5,
                                new ListNode(7,new ListNode(8,null)))));
    }

    public void printCommonNode(){
        //如果head1当前值大于head2的值，head2=head2.next
        while (head1!=null&&head2!=null){
            if (head1.val>head2.val){
                head2=head2.next;
            }
            else if (head1.val == head2.val){
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }else {
                head1=head1.next;
            }
        }
    }

    public static void main(String[] args) {
        PrintList printList=new PrintList();
        printList.init();
        printList.printCommonNode();
    }
}
