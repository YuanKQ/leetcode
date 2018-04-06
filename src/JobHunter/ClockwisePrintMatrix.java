/******************************
 * User: yuan
 * Date: 18-4-1 下午4:50
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.ArrayList;

public class ClockwisePrintMatrix {
    static public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix.length == 0)
            return null;
        ArrayList<Integer> results = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 1){
            for (int i = 0; i < col; i ++)
                results.add(matrix[0][i]);
            return results;
        }
        if (col == 1) {
            for (int i = 0; i < row; i ++)
                results.add(matrix[i][0]);
            return results;
        }
        for (int start = 0; start <= (row-1)/2 && start < col; start ++){
            int rstep = Math.max(0, row - 2*start - 1);
            int cstep = Math.max(0, col - 2 *start - 1);
            int i = start;
            int j = start;
            System.out.println(start);
            if (rstep == 0 && cstep == 0) {
                results.add(matrix[i][j]);
                break;
            }
            for (; j < start+cstep; j ++)
                results.add(matrix[i][j]);
            for (; i < start+rstep; i ++)
                results.add(matrix[i][j]);
            for (; j > start; j --)
                results.add(matrix[i][j]);
            for(; i > start; i --)
                results.add(matrix[i][j]);
        }
        return results;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        printMatrix(matrix);


    }
}
