package 剑指Offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-01
 */
public class $8 {
    public int JumpFloor(int target) {
        int result = 0;
        int k = 2;
        int m = 1;
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return m;
        }
        if (target == 2){
            return k;
        }
        for (int i = 2; i < target; i++){
            result = k + m;
            m = k;
            k = result;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new $8().JumpFloor(9));;
    }
}
