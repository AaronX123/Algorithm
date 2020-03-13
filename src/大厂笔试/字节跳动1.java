package 大厂笔试;

import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-11
 */
public class 字节跳动1 {
    public static void main(String[] args){
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        for(int  i = 0; i <= n; i++){
//            String str = s.nextLine();
//            if (str != null && str.length() != 0){
//                fix(str);
//            }
//        }
        fix("wooooow");
    }

    public static void fix(String str){
        char[] cs = str.toCharArray();

        if(cs.length < 3){
            System.out.println(str);
        }
        char pre = '@';
        char doubleSeq = '@';
        int preCount = 0;
        for(int i = 0; i < cs.length; i++){
            if(pre == '@' ){
                pre = cs[i];
            }
            else if(cs[i] == pre){
                preCount++;
                // 如果连续出现3次也就是3个相同字母
                if(preCount == 3){
                    // 遍历后面元素判断是否都是相同的
                    int k = i;
                    while (k < cs.length){
                        if (cs[k] == pre){
                            cs[k] = '@'; // 置为@后期处理
                            k++;
                        }else {
                            break;
                        }
                    }
                    preCount = 0;
                }
                else if(preCount == 2 && doubleSeq == '@'){
                    doubleSeq = cs[i];
                }
                // 此时触发AABB,去掉当前位置元素
                else if(preCount == 2 && doubleSeq != '@'){
                    cs[i] = '@';
                }
            }
            else if(cs[i] != pre){
                // 判断下和前2个和Pre是否相同，如果相同就是AAB情况，不同就是AABC情况
                if(i - 2 >= 0 && cs[i - 2] != pre){
                    doubleSeq = '@';
                }
                pre = cs[i];
                preCount = 1;
            }
        }
        char[] res = new char[cs.length];
        int idx = 0;
        for(int i = 0; i < cs.length; i++){
            if(cs[i] != '@'){
                res[idx++] = cs[i];
            }
        }
        System.out.println(new String(res));
    }
}
