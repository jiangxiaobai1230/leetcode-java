package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-18 10:15
 */
public class No98 {

    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        return isValidBST(root,null,null);

    }
    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max) {
        if(root==null)return true;
        if(min!=null&&min.val>=root.val)return false;
        if(max!=null&&max.val<=root.val)return false;
        return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);


    }


    public static void main(String[] args) {

        //输入：root = [2,1,3]
        //输出：true
        //示例 2：
        //
        //
        //输入：root = [5,1,4,null,null,3,6]
        //输出：false
        //解释：根节点的值是 5 ，但是右子节点的值是 4 。

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        No98 no98 = new No98();
        System.out.println(no98.isValidBST(root));


        root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(no98.isValidBST(root));

    }
}
