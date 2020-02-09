package designpattern.factory.productImpl;

import designpattern.factory.Product;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-09-22
 */
public class TV implements Product {
    @Override
    public void properties() {
        System.out.println("这是电视的属性");
    }
}
