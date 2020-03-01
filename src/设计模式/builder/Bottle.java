package 设计模式.builder;

/**
 * 瓶子来装饮料
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
