package test;

public class Starter extends java.lang.Thread {
    private int x=2;
    public static void main(String[] args)throws Exception{
        new Starter().makeltSo();
    }
    public Starter(){
        x=5;
        start();
    }
    public void makeltSo()throws Exception{
        join();
        x=x-1;
        System.out.println(x);
    }
    public void run(){
        x*=2;
    }
}