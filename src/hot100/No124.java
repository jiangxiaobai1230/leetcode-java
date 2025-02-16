package src.hot100;

import src.dp.TreeNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-20 23:42
 */
public class No124 {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return ans;
    }
    int dfs(TreeNode node){
        if(node==null)return 0;
        int left=dfs(node.left),right=dfs(node.right),num=node.getVal();
        if(left>0)num+=left;
        if(right>0)num+=right;
        ans=Math.max(ans,num);
        return Math.max(node.getVal(), Math.max(left,right)+node.getVal());

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：root = [1,2,3]
        //输出：6
        //解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
        //示例 2：
        //
        //
        //输入：root = [-10,9,20,null,null,15,7]
        //输出：42
        //解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        No124 no124 = new No124();
        System.out.println(no124.maxPathSum(root));
        root = new TreeNode(-10);
        node1 = new TreeNode(9);
        node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(no124.maxPathSum(root));

    }
}
