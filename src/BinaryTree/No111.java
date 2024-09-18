package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-08 22:08
 */
public class No111 {

    public int minDepth(TreeNode root) {
        int min=0;
        if(root==null)return 0;
        else{
            if(root.left==null && root.right==null)return 1;

            int left=minDepth(root.left);
            int right=minDepth(root.right);
            if(root.left==null || root.right==null) return left+right+1;
            else return Math.min(left,right)+1;
        }

    }

    public static void main(String[] args) {

        //输入：root = [3,9,20,null,null,15,7]
        //输出：2
        //示例 2：
        //
        //输入：root = [2,null,3,null,4,null,5,null,6]
        //输出：5
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new No111().minDepth(root));

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right = new TreeNode(6);
        System.out.println(new No111().minDepth(root2));



    }
}
