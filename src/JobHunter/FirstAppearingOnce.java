/******************************
 * User: yuan
 * Date: 18-4-26 上午8:53
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import java.util.HashMap;

public class FirstAppearingOnce {
    HashMap<Character, Integer> hashMap = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (hashMap.containsKey(ch))
            hashMap.put(ch, hashMap.get(ch)+1);
        else hashMap.put(ch, 1);
    }

    public static void main(String[] args) {
        System.out.println((int)Character.MAX_VALUE);
    }
}
