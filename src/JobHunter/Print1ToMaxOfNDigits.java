/******************************
 * User: yuan
 * Date: 18-3-31 上午10:50
 * Email: kq_yuan@outlook.com
 *
 * Description: [剑指Offer 面试题12]
 * 输入数字n，按顺时打印出从1到最大的n位十进制数。比如输入3.则打印出1,2,3一直到最大的3位数999.
 *
 ******************************/
package JobHunter;

public class Print1ToMaxOfNDigits {
    void Print1toMaxOfNDigits_1(int n) {
        if (n < 0)
            return;
        int[] nums = new int[n];
        while (increment(nums))
            PrintNums(nums);
    }

    private boolean increment(int[] nums) {
        int takeOver = 0;
        for (int i = nums.length - 1; i >= 0; i --){
            int sum = nums[i] + takeOver;
            if (i == nums.length - 1)
                sum ++;
            if (sum >= 10) {
                if (i == 0)
                    return false;
                takeOver = 1;
                nums[i] = sum - 10;
            } else {
                nums[i] = sum;
                return true;
            }
        }
        return false;
    }

    void PrintNums(int[] nums){
        boolean flag = false;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] !=0 || flag){
                System.out.print(nums[i]);
                flag = true;
            }
        }
        System.out.println();
    }

    void PrintNums(byte[] nums){
        boolean flag = false;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] !=0 || flag){
                System.out.print(nums[i]);
                flag = true;
            }
        }
        System.out.println();
    }

    void Print1ToMaxOfNDigits_2(int n) {
        if (n <= 0)
            return;
        byte[] nums = new byte[n];
        for (byte i = 0; i < 10; i ++){
            nums[0] = (byte)i;
            Print1toMaxOfNDigits_recursive(nums, n, 0);
        }
    }

    private void Print1toMaxOfNDigits_recursive(byte[] nums, int n, int i) {
        if (i == n - 1) {
            PrintNums(nums);
            return;
        }
        for (byte j = 0; j < 10; j ++) {
            nums[i + 1] = j;
            Print1toMaxOfNDigits_recursive(nums, n, i+1);
        }
    }

    public static void main(String[] args) {
        new Print1ToMaxOfNDigits().Print1ToMaxOfNDigits_2(9);
    }
}
