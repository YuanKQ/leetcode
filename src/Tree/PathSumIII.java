/******************************
 * User: yuan
 * Date: 18-3-14 下午9:30
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package Tree;

public class PathSumIII {

    static private int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        pathCount(root, sum, sum);
        return count;
    }

    public void pathCount(TreeNode root, int sum, int target) {
        if (root == null)
            return;
        if (root.val == sum)
            count ++;

        pathCount(root.left, sum - root.val, target);
        pathCount(root.right, sum - root.val, target);
        pathCount(root.left, target - root.val, target);
        pathCount(root.right, target - root.val, target);
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node55 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node8.left = node13;
        node8.right = node44;
        node11.left = node7;
        node11.right = node2;
        node44.left = node5;
        node44.right = node1;

        System.out.println(new PathSumIII().pathSum(node5, 22));
    }
}
