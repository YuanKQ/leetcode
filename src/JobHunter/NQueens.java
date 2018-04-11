/******************************
 * User: yuan
 * Date: 18-4-6 下午7:30
 * Email: kq_yuan@outlook.com
 *
 * Description: [剑指Offer 面试题28 拓展题]
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

   Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

   For example,
   There exist two distinct solutions to the 4-queens puzzle:

   [
    [".Q..",  // Solution 1
    "...Q",
    "Q...",
    "..Q."],

    ["..Q.",  // Solution 2
    "Q...",
    "...Q",
    ".Q.."]
   ]

 ******************************/
package JobHunter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> rs = new ArrayList<>();
        if (n == 0)
            return rs;
        int[] pos = new int[n];
        for (int i = 0; i < n; i ++)
            pos[i] = i;
        solveNQueens(pos, 0, rs);
        return rs;
    }

    public void solveNQueens(int[] pos, int begin, List<List<String>> rs) {
        if (begin == pos.length){
            if (isQueens(pos))
                rs.add(transfer(pos));
        }
        for (int i = begin; i < pos.length; i ++){
            int tmp = pos[begin];
            pos[begin] = pos[i];
            pos[i] = tmp;
            solveNQueens(pos, begin+1, rs);
            tmp = pos[begin];
            pos[begin] = pos[i];
            pos[i] = tmp;
        }

    }

    public boolean isQueens(int[] pos){
        for (int i = 0; i < pos.length-1; i ++)
            for (int j = i+1; j < pos.length; j ++)
                if (i - j == pos[i] - pos[j] || j - i == pos[i] - pos[j])
                    return false;
        return true;
    }

    public List<String> transfer(int[] pos){
        List<String> sl = new ArrayList<String>();
        for(int p: pos){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (; i < p; i ++){
                sb.append(".");
            }
            sb.append("Q");
            for (i = i + 1; i < pos.length; i ++)
                sb.append(".");
            sl.add(sb.toString());
        }
        return sl;
    }


    public static void main(String[] args) {
     System.out.println(new NQueens().solveNQueens(4).size());
    }
}
