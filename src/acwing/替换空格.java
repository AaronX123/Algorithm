package acwing;

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。
 *
 * 你可以假定输入字符串的长度最大是1000。
 * 注意输出字符串的长度可能大于1000。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-16
 */
public class 替换空格 {
    public static String replaceSpaces(StringBuffer stringBuffer){
        char[] chars = stringBuffer.toString().toCharArray();
        // 先找到空格的个数
        int spaces = 0;
        for (char c : chars) {
            if (c == ' '){
                spaces++;
            }
        }
        char[] result = new char[stringBuffer.length() + 2 * spaces];
        int resultIndex = result.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' '){
                result[resultIndex--] = '0';
                result[resultIndex--] = '2';
                result[resultIndex--] = '%';
            }else {
                result[resultIndex--] = chars[i];
            }
        }
        return new String(result);
    }


}
