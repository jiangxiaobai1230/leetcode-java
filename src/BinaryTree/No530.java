package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-18 10:43
 */
public class No530 {
    private int num=Integer.MAX_VALUE;
    private TreeNode pre=null;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        traversal(root);
        return num;
    }
    public void traversal(TreeNode root){
        if(root==null)return;
        traversal(root.left);

        if(pre!=null){
//            num=Math.min(num,Math.abs(root.val-pre.val));

            num=Math.min(num,root.val-pre.val);
        }
        pre=root;
        traversal(root.right);

    }
    public static void main(String[] args) {

        //输入：root = [4,2,6,1,3]
        //输出：1
        //示例 2：
        //
        //
        //输入：root = [1,0,48,null,null,12,49]
        //输出：1
        //

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        No530 no530 = new No530();
        System.out.println(no530.getMinimumDifference(root));


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(48);
        root2.right.left = new TreeNode(12);
        root2.right.right = new TreeNode(49);
        no530 = new No530();
        System.out.println(no530.getMinimumDifference(root2));

    }
}
