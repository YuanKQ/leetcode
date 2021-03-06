/******************************
 * User: yuan
 * Date: 18-3-17 上午10:27
 * Email: kq_yuan@outlook.com
 *
 * Description: [LeetCode #241]
   Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

   Example 1
   Input: "2-1-1".

   ((2-1)-1) = 0
   (2-(1-1)) = 2
   Output: [0, 2]

   Example 2
   Input: "23-45"

   (2*(3-(4*5))) = -34
   ((2*3)-(4*5)) = -14
   ((2*(3-4))*5) = -10
   (2*((3-4)*5)) = -10
   (((2*3)-4)*5) = 10
   Output: [-34, -14, -10, -10, 10]
 ******************************/
package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList<Integer>();
        if (input.length() == 0) {
            results.add(0);
            return results;
        }

        for (int i = 0; i < input.length(); i ++) {
            if (isOperator(input.charAt(i))){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l: left)
                    for (int r: right)
                        results.add(compute(l, r, input.charAt(i)));
            }
        }

        if (results.size() == 0)
            results.add(Integer.parseInt(input));
        return results;
    }

    public boolean isOperator(char operator) {
        if (operator == '+' || operator == '*' || operator == '-')
            return true;
        return false;
    }

    public int compute(int l, int r, char operator) {
        switch (operator) {
            case '+': return l + r;
            case '-': return l - r;
            case '*': return l * r;
            default: return 0;
        }
    }

    static public void printIntArray(List<Integer> ary) {
        for (int a: ary)
            System.out.println(a);
    }

    public static void main(String[] args) {
        printIntArray(new DifferentWaysToAddParentheses().diffWaysToCompute("11"));
    }
}
