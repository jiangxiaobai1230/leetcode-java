package src.BinaryTree;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-01 22:49
 */
public class No145 {

    //迭代法-后序遍历
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null)return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            res.add(node.val);
            if(node.left!=null)stack.push(node.left);
            if(node.right!=null)stack.push(node.right);


        }
        Collections.reverse(res);


        return res;

    }
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        postOrderTree(root, res);
//        return res;
//
//    }
//
//    public static void postOrderTree(TreeNode cur, List<Integer> res) {
//
//        if (cur == null) {
//            return;
//        } else {
//
//            postOrderTree(cur.left, res);
//            postOrderTree(cur.right, res);
//            res.add(cur.val);
//        }
//
//
//    }
    public static void main(String[] args) {

        //输入：root = [1,null,2,3]
        //输出：[1,2,3]
        //示例 2：
        //
        //输入：root = []
        //输出：[]
        //示例 3：
        //
        //输入：root = [1]
        //输出：[1]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer>res=postorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }


        root=null;
        res=postorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
        root=new TreeNode(1);
        res=postorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
