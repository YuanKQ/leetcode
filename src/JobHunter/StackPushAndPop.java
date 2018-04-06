/******************************
 * User: yuan
 * Date: 18-4-3 下午8:11
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.Stack;

public class StackPushAndPop {
    static public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> helpStack = new Stack<Integer>();
        int index = 0;
        for (int i = 0; i < popA.length; i ++){
            if (helpStack.isEmpty() || helpStack.peek() != popA[i]){
                if (index < pushA.length) {
                    for (; pushA[index] != popA[i]; index++)
                        helpStack.push(pushA[index]);
                    if (pushA[index] == popA[i]) {
                        helpStack.push(pushA[index]);
                        index++;
                    }
                }
            }
            if (helpStack.peek() != popA[i])
                return false;
            helpStack.pop();

        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4, 3,5,1,2};
        IsPopOrder(pushA, popA);
    }
}
