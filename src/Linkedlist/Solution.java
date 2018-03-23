/******************************
 * User: yuan
 * Date: 18-3-19 下午9:17
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package Linkedlist;


import Tree.TreeNode;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        return helpConstructTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public TreeNode helpConstructTree(int[] pre, int pstart, int pend, int[] in, int istart, int iend){
        if (pstart > pend || istart > iend)
            return null;
        TreeNode root = new TreeNode(pre[pstart]);
        if (pstart == pend || istart == iend)
            return root;
        int inRoot = findInorder(in, istart, iend, pre[pstart]);
        int num = istart - inRoot;
        root.left = helpConstructTree(pre, pstart + 1, pstart+num, in, istart, inRoot-1);
        root.right = helpConstructTree(pre, pstart+num+1, pend, in, inRoot+1, iend);

        return root;
    }

    public int findInorder(int[] in, int istart, int iend, int target) {
        for (int i = istart; i <= iend; i++)
            if (target == in[i])
                return i;
        return istart;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 3, 4,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};
        new Solution().reConstructBinaryTree(pre, in);
        System.out.println("end");
    }
}