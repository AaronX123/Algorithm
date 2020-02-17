package acwing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *
 * 注意：
 *
 * 输入的路径不为空；
 * 所有出现的字符均为大写英文字母；
 * 样例
 * matrix=
 * [
 *   ["A","B","C","E"],
 *   ["S","F","C","S"],
 *   ["A","D","E","E"]
 * ]
 *
 * str="BCCE" , return "true"
 *
 * str="ASAE" , return "false"
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 矩阵中的路径 {
    static class Point{
        int x;
        int y;
        char val;
        public Point(int x, int y, char val) {
            this.x = x;
            this.y = y;
        }
    }

    static int count = 0;

    public static boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || str == null || matrix.length <= 0 || str.length() <= 0){
            return false;
        }
        // 先找到所有满足的起点
        char[] target = str.toCharArray();
        char start = target[0];
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == start){
                    int[][] book = new int[matrix.length][matrix[0].length];
                    flag |= hasPath0(matrix,book,target,i,j);
                    if (flag){
                        return true;
                    }
                }
            }
        }
        return flag;
    }

    private static boolean hasPath0(char[][] matrix, int[][] book, char[] target, int x, int y){
        if (book[x][y] != 1 && matrix[x][y] == target[count]){
            book[x][y] = 1;
            count++;
            if (count == target.length){
                return true;
            }else {
                boolean f = false;
                // 往上走
                if (x - 1 >= 0 && y < matrix[0].length){
                    f |= hasPath0(matrix,book,target,x - 1,y);
                }
                // 往右走
                if (!f && x >= 0 && y + 1 < matrix[0].length){
                    f |= hasPath0(matrix,book,target,x,y + 1);
                }
                // 往下走
                if (!f && x + 1 < matrix.length && y < matrix[0].length){
                    f |= hasPath0(matrix,book,target,x + 1,y);
                }
                // 往左走
                if (!f && x >= 0 && y - 1 >= 0){
                    f |= hasPath0(matrix, book, target, x, y - 1);
                }
                if (!f){
                    book[x][y] = 0;
                    count--;
                }
                return f;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}
        };

        char[][] matrix2 = new char[][]{
                {'V', 'G', 'K', 'T', 'C'},{'Q','H','P','A','J'},{'Q','Q','S','X','T'}
        };
        //System.out.println(hasPath(matrix,"ABCEFSADEESE"));
        System.out.println(hasPath(matrix2,"GHPS"));
    }
}
