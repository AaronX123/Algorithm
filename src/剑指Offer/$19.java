package 剑指Offer;

import java.util.ArrayList;

/**
 *
 *
 * @author xiaoyouming
 * @version 1.0
 * @since 2019-11-04
 */
public class $19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        if (col == 0){
            return new ArrayList<>();
        }
        int cycleNumber = ((col > row ? row : col) - 1) / 2 + 1;
        ArrayList<Integer> result = new ArrayList<>(row * col);
        for (int i = 0; i < cycleNumber; i++) {
            //打印从左到右
            for (int a = i; a < col - i; a++){
                result.add(matrix[i][a]);
            }
            //打印从右上到右下
            for (int b = i + 1; b < row - i; b++){
                result.add(matrix[b][col - i - 1]);
            }
            //打印从右到左
            for (int c = col - i - 2; (c >= i) && (row - 1 - i != i); c--){
                result.add(matrix[row - i - 1][c]);
            }
            //打印从左下到左上
            for (int d = row - i - 2; (d > i) && (col - 1 - i != i); d--){
                result.add(matrix[d][i]);
            }
        }
        return result;
    }


    public ArrayList<Integer> printMatrix2(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length,m = array[0].length;
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
            for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }
}
