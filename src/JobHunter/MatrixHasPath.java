/******************************
 * User: yuan
 * Date: 18-4-27 下午10:28
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.Stack;

public class MatrixHasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || matrix.length == 0 || str == null || str.length == 0)
            return true;
        boolean[] trace = new boolean[matrix.length];
        for (int row = 0; row < rows; row ++)
            for (int col = 0; col < cols; col ++){
                if (hasPath(matrix, row, rows, col, cols, str, 0, trace))
                    return true;
            }
        return false;
    }

    public boolean hasPath(char[] matrix, int row, int rows, int col, int cols, char[] str, int si, boolean[] trace)
    {
        if (si == str.length)
            return true;
        boolean has = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && !trace[row*cols+col] && matrix[row*cols+col]==str[si]){
            si ++;
            trace[row*cols+col] = true;
            has = hasPath(matrix, row+1, rows, col, cols, str, si, trace)
                    || hasPath(matrix, row-1, rows, col, cols, str, si, trace)
                    || hasPath(matrix, row, rows, col+1, cols, str, si, trace)
                    || hasPath(matrix, row, rows, col-1, cols, str, si, trace);
            if (!has){
                si --;
                trace[row*cols+col] = false;
            }

        }
        return has;
    }

    public static void main(String[] args) {
        new MatrixHasPath().hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray());
    }
}
