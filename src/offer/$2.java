package offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-10-31
 */
public class $2 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("hello world")));
    }
    public static String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int index = 0;
        for (char aChar : chars) {
            if (aChar == ' '){
                index++;
            }
        }
        int k = 0;
        char[] newChar = new char[chars.length + index*2];
        for (char c : chars) {
            if (c == ' '){
                newChar[k++] = '%';
                newChar[k++] = '2';
                newChar[k++] = '0';
            }else {
                newChar[k] = c;
                k++;
            }
        }
        return new String(newChar);
    }
}
