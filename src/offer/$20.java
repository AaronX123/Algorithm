package offer;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-05
 */
public class $20 {
    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    private Integer temp = null;

    public void push(int node) {
        if(temp == null || node <= temp){
            temp = node;
            data.push(node);
            min.push(node);
        }else{
            data.push(node);
        }
    }

    public void pop() {
        int data1 = data.pop();
        int data2 = min.peek();
        if(data1 == data2){
            min.pop();
            temp = min.peek();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return temp;
    }
}
