package offer;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-11
 */
public class $50 {
    public int strToInt(String str) {
        if (str == null || "".equals(str)){
            return 0;
        }
        char[] chars = str.toCharArray();
        if (!isValid(chars)){
            return 0;
        }
        boolean negative = chars[0] == '-';
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;
        int res = 0, cur = 0;
        for (int i = negative ? 1 : 0; i < chars.length; i++){
            cur = '0' - chars[i];
            if ((res < minq) || (res == minq && cur < minr)){
                return 0;
            }
            res = res * 10 + cur;
        }
        if (!negative && res == Integer.MIN_VALUE){
            return 0;
        }
        return negative ? res : -res;
    }

    public static boolean isValid(char[] chars){
        if (chars[0] != '-' && chars[0] != '+' && (chars[0] < '0' || chars[0] > '9')){
            return false;
        }
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == 0)){
            return false;
        }
        if (chars[0] == '0' && chars.length > 1){
            return false;
        }
        if (chars[0] == '+' && chars.length == 1){
            return false;
        }
        if (chars[0] == '+'){
            chars[0] = '0';
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        new $50().strToInt("+123");
    }
}
