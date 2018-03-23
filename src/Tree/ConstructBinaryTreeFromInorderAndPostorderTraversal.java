/******************************
 * User: yuan
 * Date: 18-3-19 上午10:20
 * Email: kq_yuan@outlook.com
 *
 * Description:
 *
 ******************************/
package Tree;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int p_inorder;
    int p_postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p_inorder = inorder.length - 1;
        p_postorder = postorder.length-1;
        return helper(inorder, postorder, null);
    }
    public TreeNode helper(int[] inorder, int[] postorder, TreeNode end){
        if(p_postorder < 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[p_postorder--]);
        if(inorder[p_inorder] != root.val){
            root.right = helper(inorder,postorder,root);
        }
        p_inorder--;
        if((end == null) || (inorder[p_inorder] != end.val)){
            root.left = helper(inorder,postorder,end);
        }
        return root;
    }

    /*
    // 我的版本
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        if (inorder.length == 1)
            return new TreeNode(inorder[0]);
        // for (int i = 0; i < inorder.length; i ++)
        //     map.put(inorder[i], i);

        return helpBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helpBuildTree(int[] inorder, int ih, int it, int[] postorder, int ph, int pt) {
        if (ih > it || ph > pt)
            return null;
        TreeNode root = new TreeNode(postorder[pt]);
        int index = search(inorder, postorder[pt], ih, it);
        int num = index - ih;
        root.left = helpBuildTree(inorder, ih, index - 1, postorder, ph, ph + num - 1);
        root.right = helpBuildTree(inorder, index + 1, it, postorder, ph + num, pt-1);
        return root;

    }

    public int search(int[] inorder, int postvalue, int ih, int it) {
        for (int i = ih; i <= it; i ++)
            if (inorder[i] == postvalue)
                return i;
        return 0;
    }*/

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder);
    }
}
