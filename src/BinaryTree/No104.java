package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-08 22:07
 */
public class No104 {
    public int maxDepth(TreeNode root) {
        int max=0;
        if(root==null)return 0;
        else{
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

    public static void main(String[] args) {

        //输入：root = [3,9,20,null,null,15,7]
        //输出：3
        //示例 2：
        //
        //输入：root = [1,null,2]
        //输出：2

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new No104().maxDepth(root));

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        System.out.println(new No104().maxDepth(root2));

    }
}
