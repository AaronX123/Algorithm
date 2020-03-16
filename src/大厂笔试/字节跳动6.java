package 大厂笔试;

import java.util.Scanner;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-03-15
 */
public class 字节跳动6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sa = scanner.nextLine().split(" ");
        length = Integer.valueOf(sa[0]);
        width = Integer.valueOf(sa[1]);
        int[][] map = new int[width][length];
        int[][] visited = new int[width][length];
        for (int i = 0; i < width; i++) {
            String[] saa = scanner.nextLine().split(" ");
            for (int j = 0; j < length; j++) {
                map[i][j] = Integer.valueOf(saa[j]);
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == -2){
                    dfs(map,i,j,1,false,visited);
                    break;
                }
            }
        }
        System.out.println(res);
    }

    private static int length = 0;
    private static int width = 0;
    private static int res = Integer.MAX_VALUE;
    private static void dfs(int[][] map, int curX, int curY, int step, boolean jump, int[][] visited){
        int c = map[curX][curY];
        if (map[curX][curY] == -3){
            if (res > step){
                res = step;
            }
            return;
        }
        if (map[curX][curY] == -1) return;
        if (map[curX][curY] == 1 && !jump){
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {

                    if ((map[i][j] == 1) && (i != curX || j != curY )){
                        visited[i][j] = 5;
                        dfs(map,i,j,step + 1,true,visited);
                        break;
                    }
                }
            }
        }
        if (map[curX][curY] == 2 && !jump){
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i != curX && j != curY && (map[i][j] == 2)){
                        visited[i][j] = 5;
                        dfs(map,i,j,step + 1,true,visited);
                        break;
                    }
                }
            }
        }
        if (curX - 1 > -1 && visited[curX - 1][curY] != 5){
            // 往上走
            visited[curX][curY] = 5;
            dfs(map,curX - 1, curY,step + 1,false,visited);
        }
        // 往右走
        if (curY + 1 < length && visited[curX][curY + 1] != 5){
            visited[curX][curY] = 5;
            dfs(map,curX, curY + 1, step + 1,false,visited);
        }
        // 往下走
        if (curX + 1 < width && visited[curX + 1][curY] != 5){
            visited[curX][curY] = 5;
            dfs(map,curX + 1, curY, step + 1,false,visited);
        }
        // 往左走
        if (curY - 1> - 1 && visited[curX][curY - 1] != 5){
            visited[curX][curY] = 5;
            dfs(map, curX, curY - 1, step + 1,false,visited);
        }
        visited[curX][curY] = 0;
    }

}
