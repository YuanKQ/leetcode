/******************************
 * User: yuan
 * Date: 18-3-23 下午10:03
 * Email: kq_yuan@outlook.com
 *
 * Description: [LeetCode #415]
   Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

   Note:

   The length of both num1 and num2 is < 5100.
   Both num1 and num2 contains only digits 0-9.
   Both num1 and num2 does not contain any leading zero.
   You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * Tips:
   注意result下标的处理
 ******************************/
package StringOperation;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = Math.max(i, j);
        int[] result = new int[k + 1];

        int add1 = 0;
        int add2 = 0;
        int sum = 0;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            add1 = i >= 0 ? (num1.charAt(i) - '0') : 0;
            add2 = j >= 0 ? (num2.charAt(j) - '0') : 0;
            sum = add1 + add2 + carry;
            result[k] = sum % 10;
            carry = sum / 10;
            i --;
            j --;
            k --;
        }

        StringBuilder sb = new StringBuilder();
        if (carry > 0)
            sb.append(carry);
        for (int r: result)
            sb.append(r);
        return sb.toString();
    }
}
