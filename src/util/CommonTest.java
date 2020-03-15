package util;

import java.math.BigDecimal;
import java.util.Scanner;

public class CommonTest {
    public static void main(String[] args) {
        new CommonTest();
    }

    static {
        System.out.println("静态块");
    }

    {
        System.out.println("构造块");
    }

    CommonTest(){
        System.out.println("构造器");
    }
}
