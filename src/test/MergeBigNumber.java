package test;

import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-18
 */
public class MergeBigNumber {
    public static boolean check(char[] a){
        for (int i=0;i<a.length;i++){
            if(!(a[i]>='0'&&a[i]<='9')) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }
    public static String solve(String a,String b){
        if (a==null||b==null){
            throw new IllegalArgumentException();
        }
        char[] numberA = a.toCharArray();
        char[] numberB = b.toCharArray();
        check(numberA);
        check(numberB);
        char[] result = new char[numberA.length+numberB.length];
        int indexA = numberA.length-1;
        int indexB = numberB.length-1;
        int indexResult = result.length-1;
        for (int i=0;i<result.length;i++){
            //开始比较两个数
            if (indexA>=0&&indexB<0){
                result[indexResult--] = numberA[indexA--];
            }else if (indexA<0&&indexB>=0){
                result[indexResult--] = numberB[indexB--];
            }
            if (indexA>=0&&indexB>=0){
                if (numberA[indexA]>numberB[indexB]){
                    result[indexResult--] = numberA[indexA--];
                }else if (numberA[indexA]<numberB[indexB]){
                    result[indexResult--] = numberB[indexB--];
                }else {
                    //两个数相同的情况，需要比较2者的下一个数谁大？大的先走，如果下一个数还是一样的，则继续判断下一个数谁大。

                    //如果只剩一个数，如果此数比另一个数中任意一个数小则走对面
                    if (indexA==0&&indexB>=0){
                        int flag = 1;
                        for (int j=0;j<indexB;j++){
                            if (numberB[j]>numberA[indexA]){
                                flag = 0;
                            }
                        }
                        if (flag==0){
                            result[indexResult--] = numberB[indexB--];
                        }else {
                            result[indexResult--] = numberA[indexA--];
                        }
                    }
                    if (indexB==0&&indexA>=0){
                        int flag = 1;
                        for (int j=0;j<indexA;j++){
                            if (numberA[j]>numberB[indexB]){
                                flag = 0;
                            }
                        }
                        if (flag==0){
                            result[indexResult--] = numberA[indexA--];
                        }else {
                            result[indexResult--] = numberB[indexB--];
                        }
                    }
                    int indexMax = 1;
                    if (indexA>0&&indexB>0){
                        while (numberA[indexA]==numberB[indexB]){
                            if (numberA[indexA-indexMax]==numberB[indexB-indexMax]){
                                indexMax++;
                            }else {
                                if (numberA[indexA-indexMax]>numberB[indexB-indexMax]){
                                    result[indexResult--] = numberA[indexA--];
                                }else {
                                    result[indexResult--] = numberB[indexB--];
                                }
                            }
                        }
                    }
                }
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a= "";
        String b = "";
        while (scanner.hasNext()){
            a = scanner.next();
            b = scanner.next();
            break;
        }
        System.out.println(solve(a,b));
    }
}
