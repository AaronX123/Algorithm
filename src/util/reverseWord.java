package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-06
 */
public class reverseWord {
    public static void main(String[] args) {
        String s = "Hello xiao mi";
        System.out.println(reverse(s));
    }
    public static String reverse(String str){
        if (str==null){
            throw new IllegalArgumentException("字符串不能为空");
        }
        char[] s = str.toCharArray();
        List<String> stringList = new ArrayList<>();
        char[] word = new char[s.length];
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i]!=' '){
                word[index++] = s[i];
            }else {
                stringList.add(new String(word));
                word = new char[s.length];
                index = 0;
            }
        }
        stringList.add(new String(word));
        String res="";
        int len = stringList.size();
        for (int i = len - 1; i >= 0; i--){
            if (i==0){
                res+=stringList.get(i);
            }
            res+=stringList.get(i)+" ";
        }
        return res;
    }
}
