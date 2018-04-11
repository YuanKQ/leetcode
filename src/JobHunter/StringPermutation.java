/******************************
 * User: yuan
 * Date: 18-4-6 下午4:51
 * Email: kq_yuan@outlook.com
 *
 * Description: [剑指Offer 面试题28]
 *输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
  输入描述:
  输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 ******************************/
package JobHunter;

import java.util.*;
public class StringPermutation {
    public ArrayList<String> Permutation(String str) {
            ArrayList<String> rs = new ArrayList<>();
            if(str == null || str.length() == 0)
                return rs;
            char[] cs = str.toCharArray();
            // 使用TreeSet来对结果进行排序
            TreeSet<String> tmp = new TreeSet<>();
            Permutation(cs, 0, tmp);
            rs.addAll(tmp);
            return rs;
        }

        public void Permutation(char[] cs, int begin, TreeSet<String> rs){
            if (begin >= cs.length){
                String css = Arrays.toString(cs);
                rs.add(css);
            }
            for (int i = begin; i < cs.length; i ++){
                char tmp = cs[begin];
                cs[begin] = cs[i];
                cs[i] = tmp;
                Permutation(cs, begin+1, rs);
                tmp = cs[begin];
                cs[begin] = cs[i];
                cs[i] = tmp;
            }
        }

        /** 我的解法
         public ArrayList<String> Permutation(String str) {
         ArrayList<String> rs = new ArrayList<>();
         if(str == null || str.length() == 0)
         return rs;
         ArrayList<String> es = transfer(str);
         for (int i=0; i < es.size(); i ++){
         StringBuilder head = new StringBuilder(es.remove(i));
         helpBuildString(head, es, rs);
         es.add(i, head.toString());
         }
         return rs;
         }

         public void helpBuildString(StringBuilder head, ArrayList<String> es, ArrayList<String> rs){
         if (es.size() == 0){
         // 可能有字符重复
         if (!rs.contains(head.toString()))
         rs.add(head.toString());
         return;
         }

         for (int i=0; i < es.size(); i ++){
         String tmp = es.remove(i);
         head.append(tmp);
         helpBuildString(head, es, rs);
         head.deleteCharAt(head.length()-1);
         es.add(i, tmp);
         }
         }

         public ArrayList<String> transfer(String str) {
         char[] cs = str.toCharArray();
         ArrayList<String> es = new ArrayList<>();
         for (char c: cs){
         es.add(String.valueOf(c));
         }
         return es;
         }
         */
}
