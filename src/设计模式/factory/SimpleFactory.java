package 设计模式.factory;

import 设计模式.factory.productImpl.PC;
import 设计模式.factory.productImpl.Phone;
import 设计模式.factory.productImpl.TV;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class SimpleFactory {
    private static final String PHONE = "手机";
    private static final String PC = "电脑";
    private static final String TV = "电视";
    public static Product getProduct(String productType){
        if (PHONE.equals(productType)){
            return new Phone();
        }else if (PC.equals(productType)){
            return new PC();
        }else if (TV.equals(productType)){
            return new TV();
        }else {
            throw new IllegalArgumentException("没有此产品");
        }
    }

    public static void main(String[] args) {
        Product p = SimpleFactory.getProduct("手机2");
        p.properties();
    }
}
