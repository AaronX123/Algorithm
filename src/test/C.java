package test;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-09
 */
public class C extends F {
    @Override
    public void f() {
        System.out.println("C");
    }

    public static void main(String[] args) {
        new C().f();
    }
}
