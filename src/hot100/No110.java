package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 20:15
 */
public class No110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root)!=-1;
    }
    public int getDepth(TreeNode root){
        if(root==null)return 0;
        int left_depth=getDepth(root.left);
        if(left_depth==-1)return -1;
        int right_depth=getDepth(root.right);
        if(right_depth==-1)return -1;
        if(Math.abs(right_depth-left_depth)>1)return -1;
        else return Math.max(left_depth,right_depth)+1;
    }

    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        //输出：true
        //示例 2：
        //
        //
        //输入：root = [1,2,2,3,3,null,null,4,4]
        //输出：false
        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        No110 no110 = new No110();
        System.out.println(no110.isBalanced(root));
        root = new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(3)),new TreeNode(2,null,new TreeNode(4,new TreeNode(4),null)));
        System.out.println(no110.isBalanced(root));

    }
}
