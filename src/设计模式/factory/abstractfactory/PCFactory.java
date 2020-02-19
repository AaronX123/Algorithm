package 设计模式.factory.abstractfactory;

import 设计模式.factory.Product;
import 设计模式.factory.productImpl.PC;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class PCFactory implements Factory {
    @Override
    public Product getProduct() {
        return new PC();
    }
}
