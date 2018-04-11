import Tree.TreeNode;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by yuan on 2018/2/17.
 */
public class test{

    public static void main(String[] args) {

        int i = -13;
        System.out.println(i >> 1);
        System.out.println(i >> 2);
        System.out.println(i >>> 1);
        System.out.println(i >>> 2);
        System.out.println(i << 1);
        System.out.println(i << 2);
        System.out.println(i ^ (i-1));
    }

    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pClone = dummy;
        RandomListNode cur = pHead;
        while (cur != null) {
            pClone.next = new RandomListNode(cur.label);
            pClone = pClone.next;
            map.put(cur, pClone);
            cur = cur.next;
        }
        pClone = dummy.next;
        cur = pHead;
        while(cur != null) {
            if (cur.random != null)
                pClone.random = map.get(cur);
            cur = cur.next;
            pClone = pClone.next;
        }

        return dummy.next;
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}