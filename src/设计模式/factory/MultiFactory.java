package 设计模式.factory;

import 设计模式.factory.productImpl.PC;
import 设计模式.factory.productImpl.Phone;
import 设计模式.factory.productImpl.TV;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class MultiFactory {
    public static Product getPhone(){
        return new Phone();
    }
    public static Product getPC(){
        return new PC();
    }
    public static Product getTV(){
        return new TV();
    }
}
