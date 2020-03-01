package 设计模式.builder;

/**
 * 包装汉堡
 */
public class Wrapper implements Packing{
    @Override
    public String pack() {
        return "Wrapper";
    }
}
