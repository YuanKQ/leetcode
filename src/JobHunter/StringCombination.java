/******************************
 * User: yuan
 * Date: 18-4-6 下午5:04
 * Email: kq_yuan@outlook.com
 *
 * Description:
 * 求字符的所有组合。[LeetCode 面试题28]拓展题
 ******************************/
package JobHunter;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class StringCombination {
    public ArrayList<String> combination(String str){
        ArrayList<String> rs = new ArrayList<>();
        if (str == null || str.length() == 0)
            return rs;
        char[] cs = str.toCharArray();
        TreeSet<String> tm = new TreeSet<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= str.length(); i ++){
            combination(cs, sb, 0, i, tm);
        }
        rs.addAll(tm);
        return rs;
    }

    static void printArrayList(ArrayList<String> rs){
        for (String s: rs)
            System.out.println(s);
    }

    private void combination(char[] cs, StringBuffer sb, int begin, int len, TreeSet<String> tm) {
        if (len == 0) {
            tm.add(sb.toString());
            return;
        }
        if (begin == cs.length)
            return;

        for (int i = begin; i < cs.length; i ++) {
            sb.append(cs[i]);
            combination(cs, sb, i+1, len-1, tm);
            sb.deleteCharAt(sb.length()-1);
            combination(cs, sb, i+1, len, tm);
        }

    }
    public static void main(String[] args) {
        ArrayList<String> as = new StringCombination().combination("abc");
        printArrayList(as);
    }
}
