package 左程云程序员代码面试指南.chapter1;

import java.util.Stack;

/**
 * 使用2个栈来实现队列
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-20
 */
public class TwoStackOneQueue {
    private Stack<Integer> stack;
    private Stack<Integer> stack2;
    public TwoStackOneQueue(){
        this.stack = new Stack<>();
        this.stack2 = new Stack<>();
    }
    public void push(int a){
        stack.push(a);
    }
    public Integer pop(){
        if (stack.isEmpty()){
            throw new RuntimeException("Stack为空");
        }
        while (!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        Integer result = stack2.pop();
        while (!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
        return result;
    }
    public Integer peek(){
        if (stack.isEmpty()){
            throw new RuntimeException("Stack为空");
        }
        while (!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        Integer result = stack2.peek();
        while (!stack2.isEmpty()){
            stack.push(stack2.pop());
        }
        return result;
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        TwoStackOneQueue queue = new TwoStackOneQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(10);
        queue.push(7);
        queue.push(-5);
        queue.pop();
        queue.pop();
        queue.push(8);
        while (!queue.isEmpty()){
            System.out.println(queue.pop());
        }
    }
}
