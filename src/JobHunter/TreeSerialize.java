/******************************
 * User: yuan
 * Date: 18-4-27 上午8:55
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package JobHunter;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSerialize {
    static String Serialize(TreeNode root) {
        StringBuilder ss = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode pNode = root;
        q.offer(root);
        ss.append(root.val);
        ss.append(' ');
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null){
                q.offer(node.left);
                ss.append(node.left.val);
                ss.append(' ');
            }else if (node.right != null){
                ss.append('#');
                ss.append(' ');
            }

            if (node.right != null){
                q.offer(node.right);
                ss.append(node.right.val);
                ss.append(' ');
            }else if (node.left != null){
                ss.append('#');
                ss.append(' ');
            }
        }

        return ss.toString();
    }
    static TreeNode Deserialize(String str) {
        String[] ss = str.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode head = new TreeNode(Integer.valueOf(ss[0]));
        q.offer(head);
        Queue<String> qs = new LinkedList<>();
        for (int i = 1; i < ss.length; i ++)
            qs.offer(ss[i]);
        while(!q.isEmpty() && !qs.isEmpty()) {
            TreeNode cur = q.poll();
            String left = qs.poll();
            if (!left.equals("#")){
                cur.left = new TreeNode(Integer.valueOf(left));
                q.offer(cur.left);
            }
            if (!qs.isEmpty()){
                String right = qs.poll();
                if (!right.equals("#")){
                    cur.right = new TreeNode(Integer.valueOf(right));
                    q.offer(cur.right);
                }
            }

        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        String s = Serialize(root);
        System.out.println(s);
        Deserialize(s);
    }
}
