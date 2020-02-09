package designpattern.factory.abstractfactory;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new PhoneFactory();
        factory.getProduct().properties();
    }
}
