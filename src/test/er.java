package test;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-18
 */
public class er {
    public static void main(String[] args) {
        System.out.println(test3());
    }
    public static int func (){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally{
            return 3;
        }
    }
    public static String test3() {
        String str = null;
        try {
            System.out.println("try...");
            //系统退出未执行到finally语句块
            System.exit(0);
            return str;
        } finally {
            System.out.println("finally...");
        }
    }
}
