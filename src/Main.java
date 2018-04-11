/******************************
 * User: yuan
 * Date: 18-3-28 下午9:21
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/

import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {
        int [] array = new int [] {1,2,3,22,0,3};
        BitSet bitSet  = new BitSet(6);
        //将数组内容组bitmap
        for(int i=0;i<array.length;i++)
        {
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
        System.out.println(bitSet.get(22));
        String.valueOf(11111).toCharArray();
        System.out.println(10^3);
        String nums = "12345";
        System.out.println(nums.substring(2));
    }
}
