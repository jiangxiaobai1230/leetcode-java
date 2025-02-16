package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-18 23:31
 */

import src.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class N0543 {
    //https://leetcode.cn/problems/diameter-of-binary-tree/solutions/2227017/shi-pin-che-di-zhang-wo-zhi-jing-dpcong-taqma/?envType=study-plan-v2&envId=top-100-liked
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        dfs(root);
        return ans;

    }
    int dfs(TreeNode node){
       if(node==null)return 0;
       int left=dfs(node.left)+1;
       int right=dfs(node.right)+1;
       ans=Math.max(ans,left+right-2);
       return Math.max(left,right);
    }

    public static void main(String[] args) {
        //输入：root = [1,2,3,4,5]
        //输出：3
        //解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
        //示例 2：
        //
        //输入：root = [1,2]
        //输出：1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(new N0543().diameterOfBinaryTree(root));


        root=new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(new N0543().diameterOfBinaryTree(root));

    }
}
