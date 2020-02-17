package acwing;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 剪绳子 {
    public int solution(int target){
        if (target <= 3){
            return target - 1;
        }
        int res = 1;
        if (target % 3 == 1){
            res *= 4;
            target -= 4;
        }
        if (target % 3 == 2){
            res *= 2;
            target -= 2;
        }
        while (target > 0){
            res *= 3;
            target -= 3;
        }
        return res;
    }
}
