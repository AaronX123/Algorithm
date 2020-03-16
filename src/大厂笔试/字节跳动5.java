package 大厂笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-15
 */
public class 字节跳动5 {
    static class Supply{
        int fromSrc;
        int support;

        public Supply(int fromSrc, int support) {
            this.fromSrc = fromSrc;
            this.support = support;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] dw = s.nextLine().split(" ");
        int D = Integer.valueOf(dw[0]);
        int W = Integer.valueOf(dw[1]);
        dw = s.nextLine().split(" ");
        String[] sw = s.nextLine().split(" ");
        List<Supply> supplies = new ArrayList<>();
        int totalDes = 0;
        for (int i = 0; i < dw.length; i++) {
            supplies.add(new Supply(Integer.valueOf(dw[i]),Integer.valueOf(sw[i])));
            totalDes += Integer.valueOf(dw[i]);
        }

        for (Supply supply : supplies) {
            if (W - supply.fromSrc < 0){
                System.out.println(-1);
            }
        }
        int supCount = 0;
        int remainDes = D;
        int curW = W;
        while (remainDes > 0){
            for (Supply supply : supplies) {
                if (curW < remainDes){
                    curW += supply.support;
                    supCount++;
                    remainDes = D - supply.fromSrc;
                }
            }
        }
    }
}
