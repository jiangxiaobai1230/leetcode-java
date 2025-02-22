package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 20:02
 */
public class No101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return isSameTree(root.left,root.right);
    }
    public boolean isSameTree(TreeNode left,TreeNode right){
        if(left==null&&right==null)return true;
        if(left==null||right==null)return false;
        return left.val== right.val&&isSameTree(left.left,right.right)&&isSameTree(left.right,right.left);

    }

    public static void main(String[] args) {
        //输入：root = [1,2,2,3,4,4,3]
        //输出：true
        //示例 2：
        //
        //
        //输入：root = [1,2,2,null,3,null,3]
        //输出：false
        TreeNode root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(4),new TreeNode(3)));
        No101 no101 = new No101();
        System.out.println(no101.isSymmetric(root));
        root = new TreeNode(1,new TreeNode(2,null,new TreeNode(3)),new TreeNode(2,null,new TreeNode(3)));
        System.out.println(no101.isSymmetric(root));

    }

}
