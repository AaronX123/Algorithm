package util;

import java.util.*;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-04
 */
public class wdc {
    /*
     * @param args
     */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=0;i<n;i++){
            System.out.println(check(scanner.next()));
        }
    }

    public static String check(String str){
        if (str==null){
            return null;
        }
        Stack<Character> stack = new Stack<>();
        char[] s = str.toCharArray();

        for (int i=0;i<s.length;){
            if (stack.size()==0){
                stack.push(s[i++]);
            }
            if (stack.size()!=0&&stack.peek()!=s[i]){
                stack.push(s[i++]);
            }else {
                char temp = stack.pop();
                if (!stack.isEmpty()&&stack.peek()==s[i]){
                    //说明已经出现了3个相同的字符把刚才的舍去
                    i++;
                    stack.push(temp);
                }else if (i>3){
                    stack.push(temp);
                    //判断AABB类型此时删除B成为AAB
                    char[] temp2 = new char[3];
                    int index = 0;
                    while (!stack.isEmpty()&&index<3){
                        temp2[index++] = stack.pop();
                    }
                    if (temp2[1] == temp2[2]) {
                        //说明此时为AABB,删除最后一个即可,就是不添加新值。
                        stack.push(temp2[2]);
                        stack.push(temp2[1]);
                        stack.push(temp2[0]);
                    }else {
                        stack.push(temp2[2]);
                        stack.push(temp2[1]);
                        stack.push(temp2[0]);
                        stack.push(s[i]);
                    }
                    i++;
                }else {
                    stack.push(temp);
                    stack.push(s[i++]);
                }
            }
        }
        Stack<Character> stack1 = new Stack<>();
        while (!stack.isEmpty()){
            stack1.push(stack.pop());
        }
        char[] r = new char[stack1.size()];
        for (int i=0;i<r.length;i++){
            r[i]=stack1.pop();
        }
        return new String(r);
    }
}
