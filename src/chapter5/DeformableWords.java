package chapter5;

import util.Sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 判断Str1和Str2是否为变形词
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-08-29
 */
public class DeformableWords {
    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isDeformable(String str1,String str2){
        if (str1==null&&str2==null){
            return true;
        }
        if (str1!=null){
            if (str1.equals(str2)){
                return true;
            }
            if (str1.length()!=str2.length()){
                return false;
            }
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();
            int[] book = new int[256];
            for (char c:chars1){
                book[c]++;
            }
            for (char c2:chars2){
                book[c2]--;
            }
            for (int i=0;i<book.length;i++){
                if (book[i]!=0){
                    return false;
                }
            }
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Date date = new Date();
        for (int i = 0; i <10000 ; i++) {
            System.out.println(System.currentTimeMillis());
        }
    }
}
