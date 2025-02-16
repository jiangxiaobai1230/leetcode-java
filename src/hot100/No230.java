package src.hot100;

import src.BinaryTree.TreeNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-19 22:57
 */
public class No230 {

    //https://leetcode.cn/problems/kth-smallest-element-in-a-bst/solutions/2361685/230-er-cha-sou-suo-shu-zhong-di-k-xiao-d-n3he/?envType=study-plan-v2&envId=top-100-liked

    int k,res;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return res;

    }
    void dfs(TreeNode node){
        if(node==null)return;
        dfs(node.left);
        if(k==0){
            return;
        }
        if(--k==0){
            res=node.getVal();
        }
        dfs(node.right);
    }

    public static void main(String[] args) {
        //输入：root = [3,1,4,null,2], k = 1
        //输出：1
        //示例 2：
        //
        //
        //输入：root = [5,3,6,2,4,null,null,1], k = 3
        //输出：3
        //

        TreeNode node1=new TreeNode(3);
        TreeNode node2=new TreeNode(1);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(2);

        node1.left=node2;
        node1.right=node3;
        node2.right=node4;
        No230 no230 = new No230();
        System.out.println(no230.kthSmallest(node1, 1));

        node1=new TreeNode(5);
        node2=new TreeNode(3);
        node3=new TreeNode(6);
        node4=new TreeNode(2);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(1);

        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node4.left=node6;

        System.out.println(no230.kthSmallest(node1, 3));

        //[2,1,3],3
        node1=new TreeNode(2);
        node2=new TreeNode(1);
        node3=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        System.out.println(no230.kthSmallest(node1, 3));


    }
}
