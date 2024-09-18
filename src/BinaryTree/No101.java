package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-09 11:29
 */
public class No101 {

    public boolean isSymmetric(TreeNode root) {

        return root==null||isSymmetricTree(root.left,root.right);
    }
    public Boolean isSymmetricTree(TreeNode left,TreeNode right){

        if(left==null&&right==null)return true;
        else if (left==null || right==null) {
            return false;
        }else if(left.val==right.val){
            return isSymmetricTree(left.right,right.left)&&isSymmetricTree(left.left,right.right);
        }
        return false;
    }

    public static void main(String[] args) {

        //输入：root = [1,2,2,3,4,4,3]
        //输出：true
        //示例 2：
        //
        //
        //输入：root = [1,2,2,null,3,null,3]
        //输出：false
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new No101().isSymmetric(root));

        root= new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        System.out.println(new No101().isSymmetric(root));

    }
}
