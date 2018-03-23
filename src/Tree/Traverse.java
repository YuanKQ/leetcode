/******************************
 * User: yuan
 * Date: 18-3-17 下午4:50
 * Email: kq_yuan@outlook.com
 *
 * Description: 树的几种遍历方式
 * 深度优先遍历：
 *   前序遍历：根节点 --》左子树 --》右子树
 *   中序遍历：左子树 --》根节点 --》右子树
 *   后序遍历：左子树 --》右子树 --》根节点
 * 广度优先遍历/层次遍历
 ******************************/
package Tree;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class Traverse {
    public void preorderTraverse(TreeNode root, List<Integer> ary){
        if (root != null) {
            ary.add(root.val);
            preorderTraverse(root.left, ary);
            preorderTraverse(root.right, ary);
        }
    }

    public void preorderTraverseIterative(TreeNode root, List<Integer> ary) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.empty()) {
            if (pNode != null) {
                ary.add(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop().right;
            }
        }
    }

    public void inorderTraverse(TreeNode root, List<Integer> ary){
        if (root != null) {
            inorderTraverse(root.left, ary);
            ary.add(root.val);
            inorderTraverse(root.right, ary);
        }
    }

    public void inorderTraverseIterative(TreeNode root, List<Integer> ary){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.empty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop();
                ary.add(pNode.val);
                pNode = pNode.right;
            }
        }

    }

    public void postorderTraverse(TreeNode root, List<Integer> ary){
        if (root != null) {
            postorderTraverse(root.left, ary);
            postorderTraverse(root.right, ary);
            ary.add(root.val);
        }
    }

    public void postorderTraverseIterative(TreeNode root, List<Integer> ary){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pNode = null;
        stack.push(root);
        TreeNode preNode = null;
        while (!stack.empty()) {
            pNode = stack.peek();
            if ((pNode.left == null && pNode.right == null) ||
                    (preNode != null && (preNode == pNode.left || preNode == pNode.right))){
                ary.add(pNode.val);
                stack.pop();
                preNode = pNode;
            } else {
                if (pNode.right != null)
                    stack.push(pNode.right);
                if (pNode.left != null)
                    stack.push(pNode.left);
            }
        }

    }

    public void levelorderTraverse(TreeNode root, List<Integer> ary){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode pNode = null;
        while (!queue.isEmpty()) {
            pNode = queue.poll();
            ary.add(pNode.val);
            if (pNode.left != null)
                queue.add(pNode.left);
            if (pNode.right != null)
                queue.add(pNode.right);

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node3.right = node6;

        List<Integer> ary = new ArrayList<>();
        List<Integer> ary1 = new ArrayList<>();
        List<Integer> ary2 = new ArrayList<>();
        List<Integer> ary3 = new ArrayList<>();
        Traverse t = new Traverse();
        t.preorderTraverseIterative(root, ary);
        t.inorderTraverseIterative(root, ary1);
        t.postorderTraverseIterative(root, ary2);
        t.levelorderTraverse(root, ary3);
        printArray(ary);
        printArray(ary1);
        printArray(ary2);
        printArray(ary3);

    }

    public static void printArray(List<?> ary) {
        for (int i = 0; i < ary.size(); i ++)
            System.out.print(ary.get(i) + "\t");
        System.out.println();
    }

}
