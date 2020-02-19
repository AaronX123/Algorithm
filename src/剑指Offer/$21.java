package 剑指Offer;

import java.util.Stack;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-05
 */
public class $21 {
    static Stack<Integer> stack = new Stack<>();
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null ){
            return false;
        }
        if (pushA.length != popA.length){
            return false;
        }
        int lastPush = 0;
        for (int i = 0; i < popA.length; i++) {
            int m = find(popA[i],pushA);
            if (m == -1){
                return false;
            }
            //说明此时在栈中，比较栈顶元素即可
            if (m < lastPush){
                if (stack.peek() != popA[i]){
                    return false;
                }
                stack.pop();
            }else {
                //不在栈中，就需要把上次压栈到这次结果中间的所有数字入栈
                for (int j = lastPush; j <= m; j++){
                    stack.push(pushA[j]);
                }
                //必然匹配到，所以需要弹出匹配到的数字
                stack.pop();
                //更新已压栈位置
                lastPush = m + 1;
            }
        }
        return stack.size() == 0;
    }

    public static int find(int a, int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1},new int[]{1}));
    }


    public boolean isPopOrder2(int [] pushA,int [] popA) {
        if(popA.length == 0 ||pushA.length!=popA.length){
            return false;
        }
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }
}
