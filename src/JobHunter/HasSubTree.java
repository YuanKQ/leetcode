/******************************
 * User: yuan
 * Date: 18-3-31 下午10:06
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import Tree.TreeNode;

public class HasSubTree {
    public boolean justifyHasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return helpHasSubtree(root1, root2);
    }

    public boolean helpHasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        boolean result = false;
        if (root1.val == root2.val)
            result = traverseTwoTree(root1, root2);
        if (!result)
            return helpHasSubtree(root1.left, root2) || helpHasSubtree(root1.right, root2);
        return result;

    }

    public boolean traverseTwoTree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        else
            return traverseTwoTree(root1.left, root2.left) && traverseTwoTree(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node7.right = node7;

        TreeNode node11 = new TreeNode(8);
        TreeNode node12 = new TreeNode(9);
        TreeNode node13 = new TreeNode(2);
        node11.left = node12;
        node11.right = node13;

        System.out.println(new HasSubTree().justifyHasSubtree(node1, node11));

    }
}
