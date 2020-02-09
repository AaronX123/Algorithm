package designpattern.singleton;

/**
 * 懒汉式与饿汉式
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class Singleton {
    private static volatile Singleton singleton;
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton == null){
                    singleton = new Singleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }
}

/**
 * 饿汉式
 */
class Singleton2 {
    private static volatile Singleton2 singleton = new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return singleton;
    }
}
