package src.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-01 22:36
 */
public class No144 {

    //迭代法-前序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null)return res;
        else {
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node=stack.pop();
                res.add(node.val);
                if(node.right!=null)stack.push(node.right);
                if(node.left!=null)stack.push(node.left);

            }

        }
        return res;

    }
//    public static List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res=new ArrayList<>();
//        preOrderTree(root,res);
//        return res;
//
//    }
//    public static void preOrderTree(TreeNode cur,List<Integer> res){
//
//        if(cur==null){
//            return ;
//        }else{
//            res.add(cur.val);
//            preOrderTree(cur.left,res);
//            preOrderTree(cur.right,res);
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
        List<Integer>res=preorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }


        root=null;
        res=preorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
        root=new TreeNode(1);
        res=preorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
