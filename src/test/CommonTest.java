package test;



import sun.misc.VM;
import util.ListNode;
import util.Person;
import util.RandomListNode;
import util.TreeNode;

import java.nio.ByteBuffer;
import java.util.*;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-22
 */
public class CommonTest {
    public static void main(String[] args) {
        CommonTest test = new CommonTest();
        //System.out.println(test.printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
        //System.out.println(test.printMatrix(new int[][]{{1},{2},{3},{4},{5}}));
        System.out.println(test.VerifySquenceOfBST(new int[]{7,4,6,5}));
        System.out.println(test.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4));
        System.out.println(test.GetNumberOfK(new int[]{1,2,3,3,3,3},3));
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

    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n &= (n-1);
        }
        return count;
    }

    public double Power(double base, int exponent) {
        int fixedExp = exponent > 0 ? exponent : -exponent;
        double res = fastPower(base,fixedExp);

        return exponent > 0 ? res : 1 / res;
    }

    private double fastPower(double base, int exp){
        double res = 1;
        double base2 = base;
        while (exp != 0){
            if ((exp & 1) != 0){
                res = res * base2;
            }
            base2 = base2 * base2;
            exp >>= 1;
        }
        return res;
    }


    public void reOrderArray(int [] array) {
        int left = -1;
        for (int i = 0; i < array.length; i++) {
            if ((array[i]) %2 == 1){
                //先保存奇数，然后将奇数到left中间的偶数全部后移
                int temp = array[i];
                //将偶数全部后移
                for (int j = i - 1; j > left; j--){
                    array[j + 1] = array[j];
                }
                //放置奇数
                array[left + 1] = temp;
                left++;
            }
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        count -= k;
        if (count < 0){
            return null;
        }
        temp = head;
        while (count != 0){
            temp = temp.next;
            count--;
        }
        return temp;
    }

    public ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode pre = null;
        ListNode next = null;

        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head = null;
        if (list1.val > list2.val){
            head = list2;
            list2 = list2.next;
        }else {
            head = list1;
            list1 = list1.next;
        }
        ListNode cur = head;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                cur.next = list2;
                list2 = list2.next;
            }else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        if (list1 != null){
            cur.next = list1;
        }

        if (list2 != null){
            cur.next = list2;
        }

        return head;
    }


    public static boolean HasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null || pRoot2 == null){
            return false;
        }
        if (isPart(pRoot1,pRoot2)){
            return true;
        }
        return HasSubtree(pRoot1.left,pRoot2) || HasSubtree(pRoot1.right,pRoot2);
    }

    private static boolean isPart(TreeNode p1, TreeNode p2){
        if (p2 == null){
            return true;
        }
        if (p1 == null || p1.val != p2.val){
            return false;
        }

        return isPart(p1.left,p2.left) && isPart(p1.right,p2.right);
    }

    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null){return new ArrayList<>();}
        ArrayList<Integer> res = new ArrayList<>();
        // 对四个方向进行处理
        int totalElement = matrix.length * matrix[0].length;
        // 绕的圈数，从0开始
        int layer = 0;
        while (res.size() < totalElement){
            // 列
            int x = 0;
            // 行
            int y = 0;
            // 从左到右
            for (x = layer,y = layer; y < matrix[0].length - layer && res.size() < totalElement; y++){
                res.add(matrix[x][y]);
            }
            // 打印从上到下
            for (x = layer + 1, y = matrix[0].length - 1 - layer; x < matrix.length - layer && res.size() < totalElement; x++){
                res.add(matrix[x][y]);
            }
            // 从右到左
            if (matrix.length > 1){
                for (x = matrix.length - 1 - layer, y = matrix[0].length - 2 - layer; y >= layer && res.size() < totalElement; y--){
                    res.add(matrix[x][y]);
                }
            }
            // 只有列数大于1才打印从下到上，否则直接被从上到下打印过了
            if (matrix[0].length > 1){
                for (x = matrix.length - 2 - layer, y = layer; x > layer && res.size() < totalElement; x--){
                    res.add(matrix[x][y]);
                }
            }
            layer++;
        }
        return res;
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length){
            return false;
        }
        int visited = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : pushA) {
            if (popA[visited] == i){
                visited++;
            }else {
                stack.push(i);
            }
        }
        for (int i = visited; i < popA.length; i++) {
            if (stack.peek() == popA[i]){
                stack.pop();
            }
        }
        return stack.empty();
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur != null){
                res.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return res;
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if ( sequence==null || sequence.length<=0 ) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }

    private boolean VerifySquenceOfBST(int [] sequence, int start, int end){
        if ( start>end )
            return true;

        int root = sequence[end];
        //遍历数组，找到右子树的值，将数组分为左子树，右子树两部分。
        int i=start;
        while( sequence[i] < root ){
            i++;
        }
        //遍历右子树，如果右子树序列中有比root小的元素说明该序列不可能是二叉排序树
        int j=i;
        while( j<end ){
            if ( sequence[j]<root ) {
                return false;
            }
            j++;
        }
        //将左子树和右子树递归，进一步判断他们是不是二叉排序树
        boolean left = VerifySquenceOfBST(sequence, start, i-1);
        boolean right = VerifySquenceOfBST(sequence, i, end-1);
        return left && right;//返回与结果
    }

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list2 = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list2.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list2));
        FindPath(root.left, target);
        FindPath(root.right, target);
        list2.remove(list2.size()-1);
        return listAll;
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    public TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;
    }


    public ArrayList<String> Permutation(String str) {
        List<String> resultList = new ArrayList<>();
        if(str.length() == 0)
            return (ArrayList)resultList;
        //递归的初始值为（str数组，空的list，初始下标0）
        fun(str.toCharArray(),resultList,0);
        Collections.sort(resultList);
        return (ArrayList)resultList;
    }

    private void fun(char[] ch,List<String> list,int i){
        //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if(i == ch.length-1){
            //判断一下是否重复
            if(!list.contains(new String(ch))){
                list.add(new String(ch));
                return;
            }
        }else{
            for(int j=i;j<ch.length;j++){
                swap(ch,i,j);
                fun(ch,list,i+1);
                swap(ch,i,j);
            }
        }
    }

    //交换数组的两个下标的元素
    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int coop = 0;
        int value = 0;
        for (int i : array) {
            if (coop == 0){
                coop++;
                value = i;
            }else if (value == i){
                coop++;
            }else {
                coop--;
            }
        }
        // 这里是为了判断是否都不存在大于一半的元素
        int c = 0;
        for (int i : array) {
            if (i == value){
                c++;
            }
        }
        return c > array.length /2 ? value : 0;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length < k){
            return new ArrayList();
        }
        ArrayList<Integer> res = new ArrayList<>();
        heapify(input);
        for (int i = 0; i < k; i++) {
            res.add(input[0]);
            input[0] = Integer.MAX_VALUE;
            heapify(input);
        }
        return res;
    }

    /**
     * 最小堆
     * @param array
     * @return
     */
    public int[] heapify(int[] array){
        int child = 0;
        for (int i = array.length - 1 >> 1; i >= 0 ; i--) {
            child = 2 * i + 1;
            if (child + 1 < array.length && array[child] > array[child + 1]){
                child++;
            }
            if (array[i] > array[child]){
                int temp = array[i];
                array[i] = array[child];
                array[child] = temp;
            }
        }
        return array;
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int cur = 0;
        int res = Integer.MIN_VALUE;
        for (int i : array) {
            if (cur >= 0){
                cur +=i;
            }else {
                cur = i;
            }
            if (cur > res) res = cur;
        }
        return res;
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long d = i * 10;
            count += (n / d) * i + Math.min(Math.max(n % d - i + 1, 0), i);
        }
        return count;
    }

    public int NumberOf1Between1AndNSolution(int n) {
        int count = 0;//1的个数
        int i = 1;//当前位
        int current = 0,after = 0,before = 0;
        while((n/i)!= 0){
            current = (n/i)%10; //高位数字
            before = n/(i*10); //当前位数字
            after = n-(n/i)*i; //低位数字
            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (current == 0)
                count += before*i;
            //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
            else if(current == 1)
                count += before * i + after + 1;
            //如果大于1,出现1的次数由高位决定,//（高位数字+1）* 当前位数
            else{
                count += (before + 1) * i;
            }
            //前移一位
            i = i*10;
        }
        return count;
    }

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 7){
            return index;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < index; ++i) {
            arr[i] = Math.min(arr[index2] * 2, Math.min(arr[index3] * 3, arr[index5] * 5));
            if (arr[i] == arr[index2] * 2){
                index2++;
            }
            if (arr[i] == arr[index3] * 3){
                index3++;
            }
            if (arr[i] == arr[index5] * 5){
                index5++;
            }
        }
        return arr[index - 1];
    }

    public int FirstNotRepeatingChar(String str) {
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }

    public int InversePairs(int [] array) {
        if(array==null||array.length==0)
        {
            return 0;
        }
        int[] copy = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length-1);//数值过大求余
        return count;

    }
    private int InversePairsCore(int[] array,int[] copy,int low,int high)
    {
        if(low==high)
        {
            return 0;
        }
        int mid = (low+high)>>1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;
        int count = 0;
        int i=mid;
        int j=high;
        int locCopy = high;
        while(i>=low&&j>mid)
        {
            if(array[i]>array[j])
            {
                count += j-mid;
                copy[locCopy--] = array[i--];
                if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
            }
            else
            {
                copy[locCopy--] = array[j--];
            }
        }
        for(;i>=low;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        // 有一边走完了
        if (p1 == null){
            p1 = pHead2;
        }else {
            p2 = pHead1;
        }
        while (p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        // 有一边走完了
        if (p1 == null){
            p1 = pHead2;
        }else {
            p2 = pHead1;
        }
        while (p1 != null && p2 != null){
            if (p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     * 思路，已经有序，则使用二分找到数字，然后左右指针移动计数
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int l = 0, r = array.length - 1;
        while (l < r){
            int mid = l + r >> 1;
            if (array[mid] > k){
                r = mid;
            }else if (array[mid] < k){
                l = mid + 1;
            }else {
                l = mid;
                break;
            }
        }
        if (array[l] == k){
            int pl = l;
            int pr = l;
            int count = 1;
            while (pl > 0){
                if (--pl > 0 && array[pl] == k){
                    count++;
                }else {
                    break;
                }
            }
            while (pr < array.length){
                if (++pr < array.length && array[pr] == k){
                    count++;
                }else {
                    break;
                }
            }
            return count;
        }
        return 0;
    }



    public int TreeDepth(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int l = dfs(root.left,depth + 1);
        int r = dfs(root.right,depth + 1);
        return Math.max(l,r);
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        if (Math.abs(depth(root.left,0) - depth(root.right,0) ) < 2){
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
        return false;
    }
    private int depth(TreeNode root, int depth){
        if (root == null){
            return depth;
        }
        int l = depth(root.left,depth + 1);
        int r = depth(root.right,depth + 1);
        return Math.max(l,r);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int sum = 0;
        for (int i : array) {
            sum ^= i;
        }
        int k = 0;
        while (!((sum >> k & 1) == 0)) k++;

        int first = 0;
        for (int i : array) {
            if ((i >> k & 1) == 0){
                first ^= i;
            }
        }
        num1[0] = first;
        num2[0] = sum ^ first;
    }
}
