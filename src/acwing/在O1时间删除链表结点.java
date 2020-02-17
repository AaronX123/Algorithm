package acwing;

import util.ListNode;

/**
 * 给定单向链表的一个节点指针，定义一个函数在O(1)时间删除该结点。
 *
 * 假设链表一定存在，并且该节点一定不是尾节点。
 *
 * 样例
 * 输入：链表 1->4->6->8
 *       删掉节点：第2个节点即6（头节点为第0个节点）
 *
 * 输出：新链表 1->4->8
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 在O1时间删除链表结点 {
    public void deleteNode(ListNode node) {
        // 把下一个节点的值赋给当前节点，然后删除下一个节点
        if (node == null){
            return;
        }
        ListNode next = node.next;
        if (next == null){
            return;
        }
        node.val = next.val;
        node.next = next.next;
        // let GC work
        next = null;
    }
}
