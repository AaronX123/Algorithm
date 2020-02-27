package 大厂笔试;

import java.math.BigInteger;

/**
 * 假设每只母牛从出生后，次年后的每年年初会生下两只母牛，并且随着年份的增加每年成倍数死亡，即第1年死1*2只母牛，。第2年死2*2只，第3年死3*2只依次类推，
 * 问题。假设第一年年初时，偶10头母牛，第二年年初后有28头母牛，类推，问第100年的年初出生后，有多少只母牛，
 * 请在java/c++之间选择一种编程语言，用递归的方法求解并完成代码的编写
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-22
 */
public class 招银科技1 {
    public static BigInteger solution(){
        return dfs(BigInteger.valueOf(10),1);
    }

    private static BigInteger dfs(BigInteger cowCount, int years){
        if (years == 100){
            return cowCount;
        }
        cowCount = cowCount.multiply(BigInteger.valueOf(3));
        cowCount = cowCount.subtract(BigInteger.valueOf(years << 1));
        return dfs(cowCount,++years);
    }
    public static void main(String[] args) {
        System.out.println(solution());
    }
}
