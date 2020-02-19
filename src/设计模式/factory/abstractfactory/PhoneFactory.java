package 设计模式.factory.abstractfactory;

import 设计模式.factory.Product;
import 设计模式.factory.productImpl.Phone;

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
