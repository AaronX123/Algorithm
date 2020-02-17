package acwing;

import util.ListNode;

import java.util.Stack;

/**
 * 输入一个链表的头结点，按照 从尾到头 的顺序返回节点的值。
 *
 * 返回的结果用数组存储。
 *
 * 样例
 * 输入：[2, 3, 5]
 * 返回：[5, 3, 2]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-16
 */
public class 从尾到头打印链表 {
    public int[] printListReversingly1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        int count = 0;
        while (p != null){
            stack.push(head.val);
            p = p.next;
            count++;
        }
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }


    public int[] printListReversingly(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null){
            p = p.next;
            count++;
        }
        int[] result = new int[count];
        p = head;
        for (int i = count - 1; i >= 0; i--) {
            result[i] = p.val;
            p = p.next;
        }
        return result;
    }
}
