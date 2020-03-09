package test;



import sun.misc.VM;
import util.Person;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-22
 */
public class CommonTest {
    public static void main(String[] args) {
        test4();
    }

    public void change(Person p){
        p.setName("阿刚");
    }


    public int finallyT(int a){
        try {
            return a + 2;
        }finally {
            return a+5;
        }
    }

    public static void test2(){
        Integer i = 22;
        List<String> list = new ArrayList<>();
        try {
            while (true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable t){
            System.out.println(i);
            System.out.println(t);
        }
    }

    public static void test3(){
        System.out.println(VM.maxDirectMemory() / 1024 / 1024 + "MB");

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(10000000);
    }

    public static void test4(){
        for (int i = 0; ; i++) {
            java.lang.Thread thread = new java.lang.Thread(() ->{
                try {
                    java.lang.Thread.sleep(10000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }



}
