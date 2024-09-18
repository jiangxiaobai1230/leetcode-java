package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-14 22:52
 */
public class No112 {
    private int sum=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        return traversal(root,targetSum);
    }
    public Boolean traversal(TreeNode node,int target) {
        if (node.left == null && node.right == null) {
            sum+= node.val;
            if (sum == target) return true;
            else {
                sum-=node.val;
                return false;
            }
        }
        sum += node.val;
        if (node.left != null) {
            boolean flag = traversal(node.left, target);
            if (flag) return true;
        }
        if (node.right != null) {
            boolean flag = traversal(node.right, target);
            if (flag) return true;
        }

        sum-=node.val;
        return false;
    }
    public static void main(String[] args) {


        //输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        //输出：true
        //解释：等于目标和的根节点到叶节点路径如上图所示。
        //示例 2：
        //
        //
        //输入：root = [1,2,3], targetSum = 5
        //输出：false
        //解释：树中存在两条根节点到叶子节点的路径：
        //(1 --> 2): 和为 3
        //(1 --> 3): 和为 4
        //不存在 sum = 5 的根节点到叶子节点的路径。
        //示例 3：
        //
        //输入：root = [], targetSum = 0
        //输出：false
        //解释：由于树是空的，所以不存在根节点到叶子节点的路径。

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        No112 no112 = new No112();
        System.out.println(no112.hasPathSum(root, 22));


        TreeNode root1 = new TreeNode(1);
        TreeNode node9 = new TreeNode(2);
        TreeNode node10 = new TreeNode(3);
        root1.left = node9;
        root1.right = node10;
        System.out.println(no112.hasPathSum(root1, 5));

        TreeNode root2 = new TreeNode();
        System.out.println(no112.hasPathSum(root2, 0));


    }
}
