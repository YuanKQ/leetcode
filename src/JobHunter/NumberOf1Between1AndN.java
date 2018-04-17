/******************************
 * User: yuan
 * Date: 18-4-11 上午11:36
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0)
            return 0;
        if (n <= 9)
            return 1;
        String nums = String.valueOf(n);
        return helpNumberOf1Between1AndN(nums, 0);
    }

    public int helpNumberOf1Between1AndN(String nums, int start){
        if (start > nums.length())
            return 0;
        int pow = nums.length() - 1 - start;
        int high = 0;
        int rest = 0;
        int next = 0;
        int first = nums.charAt(start) - '0';
        if (first > 1)
            high = power(pow);
        else
            high = Integer.valueOf(nums.substring(start+1)) + 1;


        rest = first * power(pow - 1);
        next = helpNumberOf1Between1AndN(nums, start+1);
        return high + rest + next;
    }

    public static void main(String[] args) {
     System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(10000));
    }

    int power(int n){
        int result = 1;
        for (int i = 0; i < n; i ++)
            result *= 10;
        return result;
    }
}
