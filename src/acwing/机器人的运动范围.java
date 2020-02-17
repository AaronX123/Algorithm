package acwing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个 m 行和 n 列的方格，横纵坐标范围分别是 0∼m−1 和 0∼n−1。
 *
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格。
 *
 * 但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
 *
 * 请问该机器人能够达到多少个格子？
 *
 * 样例1
 * 输入：k=7, m=4, n=5
 *
 * 输出：20
 * 样例2
 * 输入：k=18, m=40, n=40
 *
 * 输出：1484
 *
 * 解释：当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *       但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 注意:
 *
 * 0<=m<=50
 * 0<=n<=50
 * 0<=k<=100
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-02-17
 */
public class 机器人的运动范围 {
    static int steps = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0){
            return 0;
        }
        int[][] book = new int[rows + 1][cols + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        steps++;
        book[0][0] = 1;
        while (!queue.isEmpty()){
            Point p = queue.poll();
            if (p != null){
                for (int i = 0; i < 4; i++) {
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if (x >= 0 && x < rows && y >=0 && y< cols && reachable(x,y,threshold,book)){
                        queue.add(new Point(x,y));
                        book[x][y] = 1;
                        steps++;
                    }
                }
            }
        }
        return steps;
    }


    private static boolean reachable(int x, int y, int threshold, int[][] book){
        if (book[x][y] == 1){
            return false;
        }
        while (x > 0){
            threshold -= x %10;
            x /= 10;
        }
        while (y > 0){
            threshold -= y%10;
            y /= 10;
        }
        return threshold >= 0;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(0,5,6));
    }
}
