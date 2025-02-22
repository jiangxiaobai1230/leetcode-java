package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 17:59
 */
public class No104 {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int left_depth=maxDepth(root.left);
        int right_depth=maxDepth(root.right);
        return Math.max(left_depth,right_depth)+1;
    }

    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        //输出：3
        //示例 2：
        //
        //输入：root = [1,null,2]
        //输出：2

        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        No104 no104 = new No104();
        System.out.println(no104.maxDepth(root));
        root = new TreeNode(1,null,new TreeNode(2));
        System.out.println(no104.maxDepth(root));

    }
}
