package acwing;

import java.util.Stack;

/**
 * 设计一个支持push，pop，top等操作并且可以在O(1)时间内检索出最小元素的堆栈。
 *
 * push(x)–将元素x插入栈中
 * pop()–移除栈顶元素
 * top()–得到栈顶元素
 * getMin()–得到栈中最小元素
 * 样例
 * MinStack minStack = new MinStack();
 * minStack.push(-1);
 * minStack.push(3);
 * minStack.push(-4);
 * minStack.getMin();   --> Returns -4.
 * minStack.pop();
 * minStack.top();      --> Returns 3.
 * minStack.getMin();   --> Returns -1.
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 包含min函数的栈 {
    /** initialize your data structure here. */
    Stack<Integer> data = new Stack<>();
    Stack<Integer> help = new Stack<>();
    public 包含min函数的栈() {

    }

    public void push(int x) {
        data.push(x);
        if (help.isEmpty() || help.peek() > x){
            help.push(x);
        }
    }

    public void pop() {
        int temp = data.pop();
        if (help.peek() == temp){
            help.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return help.peek();
    }
}
