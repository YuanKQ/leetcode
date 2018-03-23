/******************************
 * User: yuan
 * Date: 18-3-23 下午5:43
 * Email: kq_yuan@outlook.com
 *
 * Description: [LeetCode #43]
   Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

   Note:

   The length of both num1 and num2 is < 110.
   Both num1 and num2 contains only digits 0-9.
   Both num1 and num2 does not contain any leading zero.
   You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Tips:
   注意results的下标，以及进位的处理
 ******************************/
package StringOperation;

public class MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return null;
        int len3 = num1.length() + num2.length();
        int[] results = new int[len3];

        int carry = 0;
        int product = 0;
        int i = 0;
        int j = 0;
        for (i = num1.length() - 1; i >= 0; i --) {
            for (j = num2.length() - 1; j >= 0; j --) {
                product = carry + (num1.charAt(i)-'0') * (num2.charAt(j)-'0') + results[i + j + 1];
                results[i + j + 1] = product % 10;
                carry = product / 10;
            }

            // 最高位进位
            results[i + j + 1] += carry;
            // 进位置为0
            carry = 0;
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < len3; i ++){
            if (results[i] != 0)
                break;
        }
        for (; i < len3; i ++)
            sb.append(results[i]);

        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }
}
