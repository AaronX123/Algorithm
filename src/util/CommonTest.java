package util;

import java.math.BigDecimal;
import java.util.Scanner;

public class CommonTest {
    public static void main(String[] args) {
        new CommonTest().A();
    }
    public synchronized void  A(){
        System.out.println("A");
        B();
    }
    public synchronized void B(){
        System.out.println("B");
    }
}
