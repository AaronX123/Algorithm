package acwing;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 样例
 * 输入数组：
 *
 * [
 *   [1,2,8,9]，
 *   [2,4,9,12]，
 *   [4,7,10,13]，
 *   [6,8,11,15]
 * ]
 *
 * 如果输入查找数值为7，则返回true，
 *
 * 如果输入查找数值为5，则返回false。
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-16
 */
public class 二维数组中的查找 {
    /**
     * 从左下开始找或者从右上开始找，二分
     * @param array
     * @param target
     * @return
     */
    public static boolean searchArray(int[][] array, int target) {
        if (array == null || array.length <= 0){
            return false;
        }
        // 从右上开始
        int x = 0;
        int y = array.length - 1;
        while (x < array.length && y >=0){
            int a = array[x][y];
            if (a == target){
                return true;
            }else if (a < target){
                x++;
            }else {
                y--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        searchArray(new int[][]{{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        },7);
    }
}
