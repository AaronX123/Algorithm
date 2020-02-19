package 设计模式.factory;

import 设计模式.factory.productImpl.PC;

/**
 * 通过类来获取实例
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class ProductFactory {
    public static Product getProduct(Class className) throws IllegalAccessException, InstantiationException {
        if (className.getInterfaces().length==0||className.getInterfaces()==null||!className.getInterfaces()[0].equals(Product.class)){
            throw new IllegalArgumentException("没有此类产品");
        }else {
            return (Product) className.newInstance();
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Product p = ProductFactory.getProduct(PC.class);
        p.properties();
    }
}
