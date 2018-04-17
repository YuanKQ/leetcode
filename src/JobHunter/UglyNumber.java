/******************************
 * User: yuan
 * Date: 18-4-16 下午5:21
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        if (index == 1)
            return 1;

        int flag2 = 1;
        int flag3 = 1;
        int flag5 = 1;
        int[] uglyNums = new int[index+1];
        uglyNums[1] = 1;
        int nextIndex = 2;
        while (nextIndex <= index){
            uglyNums[nextIndex] = minUgly(uglyNums[flag2]*2, uglyNums[flag3]*3, uglyNums[flag5]*5);
            while (uglyNums[flag2] * 2 <= uglyNums[nextIndex])
                flag2 ++;
            while (uglyNums[flag3] * 3 <= uglyNums[nextIndex])
                flag3 ++;
            while (uglyNums[flag5] * 5 <= uglyNums[nextIndex])
                flag5 ++;
            nextIndex ++;
        }

        return uglyNums[index];
    }

    private int minUgly(int num1, int num2, int num3) {
        int min = num1 < num2? num1: num2;
        min = min < num3? min: num3;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().GetUglyNumber_Solution(10));
    }
}
