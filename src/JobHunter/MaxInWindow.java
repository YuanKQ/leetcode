/******************************
 * User: yuan
 * Date: 18-4-27 上午11:52
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxInWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> rs = new ArrayList<>();
        if (num == null || size > num.length || size == 0)
            return rs;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < num.length; i ++) {
            if (!q.isEmpty() && i - q.peek() >= size)
                q.poll();
            if (q.isEmpty())
                q.offer(i);
            else{
                // 找到第一个大于num[i]的数
                int j = q.size() - 1;
                for (; j >= 0 && num[i] >= num[q.get(j)]; j --)
                    q.remove(j);
                q.offer(i);

            }
            if (i >= size-1)
                rs.add(num[q.peek()]);
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        new MaxInWindow().maxInWindows(num, 3);
    }
}
