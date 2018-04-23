/******************************
 * User: yuan
 * Date: 18-4-19 上午9:44
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.ArrayList;
import java.util.Comparator;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<>();
        if (sum <= 2)
            return rs;
        int target = 2 * sum;
        int threshold = (int)Math.sqrt(target);
        for(int i = 2;i <= threshold; i ++) {
            if ( target % i == 0){
                int rest = target / i;
                if (rest %2 == 0 && i % 2 == 0)
                    continue;
                int end = (i + rest - 1) >> 1;
                int start = (Math.abs(rest - i) +1) >> 1;
                ArrayList<Integer> sub = new ArrayList<Integer>();
                for (int k = start; k <= end; k ++){
                    sub.add(k);
                }
                rs.add(sub);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        new FindContinuousSequence().findContinuousSequence(3);
    }
}
