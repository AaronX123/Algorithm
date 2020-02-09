package offer;

import java.util.Stack;

/**
 * 用2个栈实现队列
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-01
 */
public class $5 {
    private Stack<Integer> dataStack = new Stack<Integer>();
    private Stack<Integer> helpStack = new Stack<Integer>();

    public void push(int node) {
        dataStack.push(node);
    }

    public int pop() {
        while (!dataStack.isEmpty()){
            helpStack.push(dataStack.pop());
        }
        int result = helpStack.pop();
        while (!helpStack.isEmpty()){
            dataStack.push(helpStack.pop());
        }
        return result;
    }

    public void push2(int val){
        dataStack.push(val);
    }

    public int pop2(){
        //辅助栈为空则将数据栈中栈尾元素上面的元素弹到辅助栈中，然后将栈顶元素给用户
        if (helpStack.isEmpty()){
            while (dataStack.size() > 1){
                helpStack.push(dataStack.pop());
            }
            return dataStack.pop();
        }else {
            return helpStack.pop();
        }
    }

}
