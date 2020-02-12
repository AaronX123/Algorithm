package offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-11
 */
public class $49 {
    public int Add(int num1,int num2) {
        while (num2 != 0){
            int temp;
            temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}
