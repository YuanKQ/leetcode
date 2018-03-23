import Tree.TreeNode;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yuan on 2018/2/17.
 */
public class  test<T> {
    static long j = 123L;
    static final int i = 12;
    static int ii = 9123;
    static final String strJ = "asdfasdf";
    static Double dJ = 12.3456;
    boolean flag;
    T gg;
    public void f(int x){
        int local = 0;
        x ++;
        x --;
        local = x;
        System.out.println(local);
    }

    static public void g(int x){
        int local = 0;
        x ++;
        x --;
        local = x;
        System.out.println(local);
    }

    public <T> void g(T x) {
        x.getClass().getName();
    }

    static public void gg() {
        int k = 0;
        System.out.println(k);

    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello world.");
        System.out.println(replaceSpace(sb));

        HashMap
    }

    static public String replaceSpace(StringBuffer str) {
        int spanCount = 0;
        for (int i = 0; i < str.length(); i ++){
            if (str.charAt(i) == ' ')
                spanCount ++;
        }
        int oldLen = str.length() - 1;
        str.setLength(oldLen + spanCount * 2 + 1 + 1);
        int newLen = str.length() - 2;

        while (oldLen >= 0 && newLen >= 0){
            if (str.charAt(oldLen) == ' '){
                str.setCharAt(newLen--, '0');
                str.setCharAt(newLen--, '2');
                str.setCharAt(newLen--, '%');
            } else
                str.setCharAt(newLen--, str.charAt(oldLen));
            oldLen --;   
        }

        return str.toString();
    }
}
