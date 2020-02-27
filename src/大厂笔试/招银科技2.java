package 大厂笔试;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出任意4个数字，通过任意加减乘除运算（包括括号），得出24，并列出所有结果（交换律导致的位置问题算同一种结果）。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-22
 */
public class 招银科技2 {
    static List<String> res = new ArrayList<>();
    static char[] op = new char[]{'+','-','*','/'};
    public static void main(String[] args) {
        new 招银科技2().solution(new int[]{3,10,3,6});
    }
    
    public List<String> solution(int[] nums){
        if (nums == null || nums.length != 4){
            return new ArrayList<>();
        }
        int target = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int[] book = new int[4];
            StringBuilder stringBuilder = new StringBuilder();
            book[i] = 1;
            stringBuilder.append(nums[i]);
            for (char c : op) {
                stringBuilder.append(c);
                for (int j = 0; j < nums.length; j++) {
                    if (book[j] != 1){
                        book[j] = 1;
                        target = calc(nums[i],nums[j],c);
                        stringBuilder.append(nums[j]);
                        for (char c2 : op) {
                            stringBuilder.append(c2);
                            for (int l = 0; l < nums.length; l++) {
                                if (book[l] != 1){
                                    book[l] = 1;
                                    target = calc(target,nums[l],c);
                                    stringBuilder.append(nums[l]);
                                    for (char c3 : op) {
                                        stringBuilder.append(c3);
                                        for (int m = 0; m < nums.length; m++) {
                                            if (book[m] != 1){
                                                stringBuilder.append(nums[m]);
                                                target = calc(target,nums[m],c);
                                                if (target == 24){
                                                    res.add(stringBuilder.toString());
                                                }
                                                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                                            }
                                        }
                                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                                    }
                                    book[l] = 0;
                                }
                            }
                        }
                        book[j] = 0;
                    }
                }
            }
            book[i] = 0;
        }
        return res;
    }
    
    private int calc(int num, int num2, char op){
        if (op == '+'){
            return num + num2;
        }
        if (op == '-'){
            return num - num2;
        }
        if (op == '*'){
            return num * num2;
        }
        if (op == '/'){
            if (num2 != 0){
                return num / num2;
            }
            throw new IllegalArgumentException("被除数不能为0");
        }
        throw new IllegalArgumentException("操作不合法");
    }


}
