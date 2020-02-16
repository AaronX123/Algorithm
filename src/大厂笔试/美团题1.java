package 大厂笔试;

import util.GCD;

/**
 * 小明绕着 n * n的跑道跑圈，每跑n + 1距离就会做一个标记，当小明重复标记时停止跑步，求标记次数,最后一次重复标记也算
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-14
 */
public class 美团题1 {
    public int solution(int n){
        if (n <= 0){
            return 0;
        }
        int d = GCD.gcd(4 * n, n + 1);
        return 4 * n / d + 1;
    }

    public static void main(String[] args) {
        System.out.println(new 美团题1().solution(8));;
    }
}
