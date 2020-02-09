package offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-01
 */
public class $9 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
    }

    /**
     *
     * @param target
     * @return
     */
    public static int JumpFloorII1(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return (int) Math.pow(2,target-1);
        }
    }

    public static int JumpFloorII(int target) {
        return 1<<target-1;
    }

}
