package offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-06
 */
public class $42 {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 数列的首项
        int a1 = 0;
        // 数列的个数
        int n = 2;

        for (;n < sum; n++){
            a1 = getFirstNumber(n,sum);
            if (a1 == -2){
                break;
            }
            if (a1!= -1){
                result.add(getSequence(a1,n));
            }

        }
        result.sort((arr1,arr2) -> {
            return arr1.get(0) - arr2.get(0);
        });
        return result;
    }

    private static double sum(double n){
//        int sum = 0;
//        while (n > 0){
//            sum += n;
//            n--;
//        }
        return ((1 + n) * (n)) /2;
    }

    /**
     * 判断是否为整数
     * @param d
     * @return
     */
    private static boolean isInteger(double d){
        return ((int)(d / 1) - d) == 0.0;
    }

    /**
     * 获取数列
     * @param a1
     * @param n
     * @return
     */
    private static ArrayList<Integer> getSequence(int a1, int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(a1);
            a1 ++;
        }
        return arrayList;
    }

    /**
     * 求出满足思路的数列首项
     * @param n 数组个数
     * @param sum 数组要求SUM
     * @return -1 表示不存在此整数
     */
    private static int getFirstNumber(int n, int sum){
        double a1 = (sum - sum(n - 1)) / n;
        // 判断是否为整数
        if (a1 <= 0){
            return -2;
        }else if (isInteger(a1)){
            return (int) a1;
        }else {
            return -1;
        }
    }


    public static void main(String[] args) {
        findContinuousSequence(15);
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
}
