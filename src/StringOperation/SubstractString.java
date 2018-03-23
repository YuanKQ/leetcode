/******************************
 * User: yuan
 * Date: 18-3-23 下午10:17
 * Email: kq_yuan@outlook.com
 *
 * Description:
 Given two non-negative integers num1 and num2 represented as string, return the difference of num1 and num2.
 ******************************/
package StringOperation;

public class SubstractString {
    static public String substractStrings(String str1, String str2) {
        String num1 = "", num2 = "";
        String flag = "";
        if (str1.length() > str2.length()){
            num1 = str1;
            num2 = str2;
        } else if (str1.length() < str2.length()) {
            num1 = str2;
            num2 = str1;
            flag = "-";
        } else {
            if (str1.compareTo(str2) >= 0) {
                num1 = str1;
                num2 = str2;
            } else {
                num1 = str2;
                num2 = str1;
                flag = "-";
            }
        }
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = Math.max(i, j);
        int[] results = new int[k + 1];
        int op1 = 0;
        int op2 = 0;
        int sub = 0;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            op1 = num1.charAt(i) - '0';
            op2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            sub = op1 - op2 - carry;
            if (sub < 0) {
                results[k] = 10 + sub;
                carry = 1;
            } else {
                results[k] = sub;
                carry = 0;
            }

            i --;
            j --;
            k --;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(flag);
        for (i = 0; i < results.length; i ++)
            if (results[i] != 0)
                break;
        for (; i < results.length; i ++)
            sb.append(results[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(substractStrings("77", "23"));
        //System.out.println(substractStrings("23", "77"));
        System.out.println(substractStrings("123", "77"));
        System.out.println("77".equals("23"));
        System.out.println("13".compareTo("23"));
    }
}
