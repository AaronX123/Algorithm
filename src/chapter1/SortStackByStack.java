package chapter1;

import java.util.Stack;

/**
 * 用一个栈来对另一个栈进行排序
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-21
 */
public class SortStackByStack {
    private Stack<Integer> data;
    private Stack<Integer> sort;
    public SortStackByStack(){
        this.data = new Stack<Integer>();
        this.sort = new Stack<Integer>();
    }

    /**
     * 思路：push的时候，比较栈顶元素，如果大于栈顶就直接放进去，否则将栈顶元素放进sort中直到 a>栈顶元素 ，然后将sort中数据在放回来。
     * @param a
     */
    public void push(int a){
        if (data.isEmpty()){
            data.push(a);
        }else {
            if (a>data.peek()){
                data.push(a);
            }else {
                while (!data.isEmpty()){
                    int temp = data.pop();
                    sort.push(temp);
                    if (a > data.peek()){
                        data.push(a);
                        while (!sort.isEmpty()){
                            data.push(sort.pop());
                        }
                        return;
                    }
                }
            }
        }
    }

    public int pop(){
        return data.pop();
    }

    public int peek(){
        return data.peek();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
    public static void main(String[] args) {
        SortStackByStack sortStackByStack = new SortStackByStack();
        sortStackByStack.push(1);
        sortStackByStack.push(3);
        sortStackByStack.push(5);
        sortStackByStack.push(7);
        sortStackByStack.push(2);
        sortStackByStack.push(4);
        while (!sortStackByStack.isEmpty()){
            System.out.println(sortStackByStack.pop());
        }
    }
}
