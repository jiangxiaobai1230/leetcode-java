package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 23:22
 */
public class No226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

    public static void main(String[] args) {
        //输入：root = [4,2,7,1,3,6,9]
        //输出：[4,7,2,9,6,3,1]
        //示例 2：
        //
        //
        //
        //输入：root = [2,1,3]
        //输出：[2,3,1]
        //示例 3：
        //
        //输入：root = []
        //输出：[]
        TreeNode root1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode root3 = new TreeNode();
        TreeNode res1 = new No226().invertTree(root1);
        TreeNode res2 = new No226().invertTree(root2);
        TreeNode res3 = new No226().invertTree(root3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

    }
}
