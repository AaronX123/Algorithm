package designpattern.factory;

import designpattern.factory.productImpl.PC;
import designpattern.factory.productImpl.Phone;
import designpattern.factory.productImpl.TV;

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
