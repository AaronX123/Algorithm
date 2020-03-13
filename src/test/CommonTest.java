package test;



import sun.misc.VM;
import util.ListNode;
import util.Person;
import util.TreeNode;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-22
 */
public class CommonTest {
    public static void main(String[] args) {
        CommonTest test = new CommonTest();
        test.replaceSpace(new StringBuffer("hello world"));
    }

    public void change(Person p){
        p.setName("阿刚");
    }


    public int finallyT(int a){
        try {
            return a + 2;
        }finally {
            return a+5;
        }
    }

    public static void test2(){
        Integer i = 22;
        List<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable t){
            System.out.println(i);
            System.out.println(t);
        }
    }

    public static void test3(){
        System.out.println(VM.maxDirectMemory() / 1024 / 1024 + "MB");

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10000000);
    }

    public static void test4(){
        for (int i = 0; ; i++) {
            java.lang.Thread thread = new java.lang.Thread(() ->{
                try {
                    java.lang.Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }


    public boolean Find(int target, int [][] array) {
        int x = array[0].length - 1;
        int y = 0;
        while(x >= 0 && y < array.length){
            if(array[x][y] == target){
                return true;
            }
            if(array[x][y] < target){
                x--;
            }else{
                y++;
            }
        }
        return false;
    }

    public String replaceSpace(StringBuffer str) {
        char[] strs = str.toString().toCharArray();
        // 首先判断有多少空格
        int c = 0;
        for (char str1 : strs) {
            if (str1 == ' ') c++;
        }
        char[] newStr = new char[str.length() + c * 2];
        // 倒着填
        c = str.length() - 1;
        for (int i = newStr.length - 1; i > -1; i--) {
            if (strs[c] == ' '){
                newStr[i--] = '0';
                newStr[i--] = '2';
                newStr[i] = '%';
                c--;
            }else {
                newStr[i] = strs[c--];
            }
        }
        return new String(newStr);
    }

    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        dfs(listNode);
        return list;
    }

    public void dfs(ListNode node){
        if (node == null){
            return ;
        }
        dfs(node.next);
        list.add(node.val);
    }


    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length == 0){
            return null;
        }
        if (pre.length == 1){
            return new TreeNode(pre[0]);
        }

        int rootValue = pre[0];

        int idx = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == rootValue){
                idx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootValue);
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,idx+1),Arrays.copyOfRange(in,0,idx+1)) ;
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,idx+1,pre.length),Arrays.copyOfRange(in,idx+1,in.length));
        return root;
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }

    public int minNumberInRotateArray(int [] array) {
        int n = array.length - 1;
        if (n < 0) return -1;
        while (n > 0 && array[n] == array[0]){
            n --;
        }
        if (array[n] >= array[0]) return array[0];

        int l = 0; int r = n;
        while (l < r){
            int mid = l + r >> 1;
            if (array[0] > array[mid]){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return array[l];
    }


    public int Fibonacci(int n) {
        if (n <= 0) return 0;
        if (n < 3) return 1;
        int last = 1;
        int llast = 1;
        int cur = 2;

        for (int i = 3; i <= n ; i++) {
            cur = llast + last;
            llast = last;
            last = cur;
        }
        return cur;
    }

    /**
     * 状态转移
     * 当前青蛙能跳是根据剩余台阶的个数决定，当剩余1个时则只有1种跳法，剩余2个时则有2种跳法。
     * dp[n] = dp[n - 1] + dp[n - 2]
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int[] dp = new int[target +1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public int JumpFloorII(int target){
        return 1 <<target - 1;
    }
}
