package 左程云程序员代码面试指南.chapter3;

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String input) {
        if(input==null){
            throw new IllegalArgumentException("输入不能为空");
        }
        char[] s = input.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            //说明是个数字
            if (s[i]>=0&&s[i]<=9){

            }
        }
        return null;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        res = solution(_input);
        System.out.println(res);
    }
    class TreeNode {
        public int val;
        public TreeNode leftNode;
        public TreeNode rightNode;

        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.leftNode=left;
            this.rightNode=right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "label=" + val +
                    ", leftNode=" + leftNode +
                    ", rightNode=" + rightNode +
                    '}';
        }
    }
}