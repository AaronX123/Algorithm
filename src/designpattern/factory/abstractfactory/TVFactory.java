package designpattern.factory.abstractfactory;

import designpattern.factory.Product;
import designpattern.factory.productImpl.TV;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class TVFactory implements Factory {
    @Override
    public Product getProduct() {
        return new TV();
    }
}
