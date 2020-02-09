package test;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-18
 */
public class OrderOfInit {
    private static String a="hello";
    OrderOfInit(){
        System.out.println(a);
    }
    {
        System.out.println("构造块执行");
    }
    static {
        System.out.println(a);
        a = "another hello";
        System.out.println(a);
    }

    public void print(){
        System.out.println(a);
    }

    public static void main(String[] args) {
        Child child = new Child();
        child.print();
    }
}
class Child extends OrderOfInit{
    private static String b="hello child";
    Child(){
        System.out.println("child initialized");
    }
    {
        System.out.println("child 构造块执行");
    }
    static {
        System.out.println("child static work");
    }
    @Override
    public void print() {
        System.out.println(b);
    }
}
