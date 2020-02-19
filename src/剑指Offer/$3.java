package 剑指Offer;

import util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-10-31
 */
public class $3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
