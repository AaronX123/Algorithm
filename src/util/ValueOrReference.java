package util;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-02
 */
public class ValueOrReference {
    public static void main(String[] args) {
        int a=1;
        int b =2;
        Object a1 = "ali";
        Object b2 = "hs";
        swap(a,b);
        swap(a1,b2);
        System.out.println(a);
        System.out.println(b);
        System.out.println(a1);
        System.out.println(b2);
    }
    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static void swap(Object a,Object b){
        String temp = (String) a;
        a = b;
        b = temp;
    }
}
