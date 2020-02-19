package 剑指Offer;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-10-31
 */
public class $1 {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{2,3,4},{5,6,7},{6,7,8}};
        System.out.println(Find(11,array));
    }
    public static boolean Find(int target, int [][] array) {
        //找到左下角
        int x = array.length-1;
        int y = 0;
        while (x>=0&&y<array[0].length){
            if (target == array[x][y]){
                return true;
            }else if (target <array[x][y]){
                x--;
            }else {
                y++;
            }
        }
        return false;
    }
}
