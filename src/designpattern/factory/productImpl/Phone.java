package designpattern.factory.productImpl;

import designpattern.factory.Product;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class Phone implements Product {
    @Override
    public void properties() {
        System.out.println("这是手机的属性");
    }
}
