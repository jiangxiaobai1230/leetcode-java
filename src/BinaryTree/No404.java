package src.BinaryTree;

import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-11 22:55
 */
public class No404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum=0;
        if(root==null)return sum;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if(node.left!=null && node.left.left==null&&node.left.right==null){
                sum+=node.left.val;
            }
            if(node.right!=null)stack.push(node.right);
            if(node.left!=null)stack.push(node.left);


        }

        return sum;
    }


    public static void main(String[] args) {

        //输入: root = [3,9,20,null,null,15,7]
        //输出: 24
        //解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
        //示例 2:
        //
        //输入: root = [1]
        //输出: 0


        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new No404().sumOfLeftLeaves(root));
        System.out.println(new No404().sumOfLeftLeaves(new TreeNode(1)));


    }
}
