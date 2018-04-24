/******************************
 * User: yuan
 * Date: 18-4-23 下午10:41
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.ArrayList;
import java.util.Iterator;

public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
       if (n <= 0 || m < 0)
           return -1;
       int[] nums = new int[n];
       int i = -1; // 报数尚未开始，所以初始值为-1
       int step = 0;
       int count = n;
       while (count > 0){  // 倘若为count>1, return的是倒数第二被删除的数字后的下一个数字，然而，这个数字很有可能早就被删除了
           i ++;
           if (i == n)
               i = 0;
           if (nums[i] == -1)
               continue;
           step ++;
           if (step == m){
               step = 0;
               nums[i] = -1;
               count --;
           }
       }

       return i;  // 最后一个被删除的数字
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution(11, 4));

    }
}
