package 左程云程序员代码面试指南.chapter1;

import java.util.Stack;

/**
 * 设计一个有getMin方法的栈
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-05
 */
public class GetMin {
    /**
     * 真正存储的栈
     */
    private Stack<Integer> rawData = new Stack<Integer>();
    /**
     * 搞一个辅助栈用于存放最小元素
     */
    private Stack<Integer> assistStack = new Stack<Integer>();

    public void push(int val){
        if (rawData.empty()){
            rawData.push(val);
            assistStack.push(val);
        }else {
            //如果辅助栈顶元素大于val,则辅助栈压入
            if (assistStack.peek()>val){
                assistStack.push(val);
                rawData.push(val);
            }else {
                rawData.push(val);
            }
        }
    }

    public int pop(){
        int temp=rawData.pop();
        if (temp>assistStack.peek()){
            return temp;
        }else {
            assistStack.pop();
            return temp;
        }
    }

    public int getMin(){
        return assistStack.peek();
    }


    public static void main(String[] args) {
        GetMin getMin=new GetMin();
        getMin.push(1);
        getMin.push(-1);
        getMin.push(11);
        getMin.push(5);
        for (int i=0;i<4;i++){
            System.out.println(getMin.getMin());
            System.out.println(getMin.pop());
        }
    }

}
