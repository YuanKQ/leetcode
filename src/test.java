import Tree.TreeNode;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;

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
        int[] ii = {1, 2, 3, 4};
        StringBuilder sb = new StringBuilder();
        String ss = "hhhh";
    }

    class Solution {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            if (root == null)
                return results;
            target -= root.val;
            if (target == 0 && root.left == null && root.right == null){
                path.add(root.val);
                results.add(new ArrayList<Integer>(path));
            }
            FindPath(root.left, target);
            FindPath(root.right, target);
            path.remove(path.size() - 1);
            return results;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                results.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return results;
    }

}
