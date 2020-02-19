package acwing;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 样例
 * 输入：
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 *
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-19
 */
public class 顺时针打印矩阵 {
    public static int[] printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        ArrayList<Integer> list = new ArrayList<>();
        int layer = 0;
        int size = matrix.length * matrix[0].length;
        while (list.size() < size){
            // 向右
            for (int i = layer; i < matrix[0].length - layer; i++) {
                list.add(matrix[layer][i]);
            }
            // 向下
            for (int i = layer + 1; i < matrix.length - layer; i++) {
                list.add(matrix[i][matrix[0].length - 1 - layer]);
            }
            // 向左
            for (int i = matrix[0].length - 1 - layer - 1; i >= layer; i--) {
                list.add(matrix[matrix.length - layer - 1][i]);
            }
            // 向上
            for (int i = matrix.length - 1 - layer - 1; i >= layer + 1; i--) {
                list.add(matrix[i][layer]);
            }
            layer++;
        }
        int[] res = new int[size];
        int i = 0;
        for (int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(printMatrix(new int[][]{{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}}));
    }
}
