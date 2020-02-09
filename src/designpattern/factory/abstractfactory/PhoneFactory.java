package designpattern.factory.abstractfactory;

import designpattern.factory.Product;
import designpattern.factory.abstractfactory.Factory;
import designpattern.factory.productImpl.Phone;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class PhoneFactory implements Factory {
    @Override
    public Product getProduct() {
        return new Phone();
    }
}
