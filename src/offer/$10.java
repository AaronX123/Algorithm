package offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-03
 */
public class $10 {
    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
    public static int RectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int result = 0;
        int temp = 2;
        int tempPre = 1;
        for (int i = 2;i < target; i++){
            result = temp + tempPre;
            tempPre = temp;
            temp = result;
        }
        return result;
    }
}
