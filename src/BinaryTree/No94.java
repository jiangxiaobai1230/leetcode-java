package src.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-01 22:50
 */
public class No94 {

    //迭代法-中序遍历,左中右，先遍历完左边的，再中间最后右边
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null)return res;
        TreeNode cur=root;
        while (cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                res.add(cur.val);
                cur=cur.right;

            }
        }

        return res;

    }

//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res=new ArrayList<>();
//        inOrderTree(root,res);
//        return res;
//
//    }
//    public static void inOrderTree(TreeNode cur,List<Integer> res) {
//
//        if (cur == null) {
//            return;
//        } else {
//
//            inOrderTree(cur.left, res);
//            res.add(cur.val);
//            inOrderTree(cur.right, res);
//        }
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
        List<Integer>res=inorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }


        root=null;
        res=inorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
        root=new TreeNode(1);
        res=inorderTraversal(root);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
