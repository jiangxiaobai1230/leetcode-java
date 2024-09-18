package src.BinaryTree;

import java.lang.management.MemoryType;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-10 22:33
 */
public class No110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if(getDepth(root)!=-1) return true;
        else return false;

    }
    public int getDepth(TreeNode root){
        if(root==null)return 0;
        int leftDepth=getDepth(root.left);
        if(leftDepth==-1)return -1;
        int rightDepth=getDepth(root.right);
        if(rightDepth==-1)return -1;
        if(Math.abs(leftDepth-rightDepth)<2){
            return Math.max(leftDepth,rightDepth)+1;
        }else return -1;

    }

    public static void main(String[] args) {

        //输入：root = [3,9,20,null,null,15,7]
        //输出：true
        //示例 2：
        //
        //
        //输入：root = [1,2,2,3,3,null,null,4,4]
        //输出：false
        //示例 3：
        //
        //输入：root = []
        //输出：true

        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new No110().isBalanced(root));

        TreeNode root1 = new TreeNode(1);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(3);
        TreeNode node15 = new TreeNode(4);
        TreeNode node16 = new TreeNode(4);
        root1.left = node11;
        root1.right = node12;
        node11.left = node13;
        node11.right = node14;
        node13.left = node15;
        node13.right = node16;
        System.out.println(new No110().isBalanced(root1));



        System.out.println(new No110().isBalanced(null));

    }
}
