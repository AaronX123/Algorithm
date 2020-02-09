package offer;

/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-02
 */
public class $32 {
    public int numberOf1Between1AndNSolution(int n) {
        StringBuffer str = new StringBuffer("");
        for(int i=1;i<=n;i++){
            str.append(i);
        }
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1') {
                count++;
            }
        }
        return count;
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1){
            return 0;
        }
        int len = getLenOfNum(n);
        if (len == 1) {
            return 1;
        }
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp;
        // 以120为例，first为1 然后百位就有 120 % 100 + 1 = 21 ,就是100 - 120的百位出现的个数，
        // 如果n = 220, first为 2 然后百位就必定包含100 - 199 也就是tmp 100个1出现的次数
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp;
        // 以120为例，first为1 然后 1 * (3-1) * (100/10) = 20
        int otherOneNum = first * (len - 1) * (tmp / 10);
        return firstOneNum + otherOneNum + NumberOf1Between1AndN_Solution(n % tmp);
    }

    public int NumberOf1Between1AndN_Solution5(int n) {
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

        private int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
