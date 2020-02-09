package test;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-09
 */
public class Constructor {

    public static void main(String[] args) {
        System.out.println("创建第一个对象：");
        Test test1 = new Test();
        System.out.println("");
        System.out.println("创建第二个对象：");
        Test test2 = new Test(5);
    }
}

class Test {
    // 静态代码块1
    static {
        System.out.println("我是静态代码块1");
    }
    // 构造代码块1：
    {
        System.out.println("我是构造代码块1");
    }

    // 构造函数1
    public Test() {
        System.out.println("我是无参构造函数");
    }

    // 构造函数2
    public Test(int t) {
        System.out.println("我是带参构造函数，" + "参数是" + t);
    }

    // 静态代码块2
    static {
        System.out.println("我是静态代码块2");
    }

    // 构造代码块2：
    {
        System.out.println("我是构造代码块2");
    }
}