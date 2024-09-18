package src.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-05 22:43
 */
public class No199 {
    private List<Integer> list;
    public void dfsrightSideView(TreeNode root,int depth){
        if(root==null)return;
        if(depth==list.size()){
            list.add(root.val);
        }
        dfsrightSideView(root.right,depth+1);
        dfsrightSideView(root.left,depth+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        list=new ArrayList<>();
        if(root==null){
            return list;
        }
        dfsrightSideView(root,0);
        return list;

    }

    public static void main(String[] args) {

        //输入: [1,2,3,null,5,null,4]
        //输出: [1,3,4]
        //示例 2:
        //
        //输入: [1,null,3]
        //输出: [1,3]
        //示例 3:
        //
        //输入: []
        //输出: []

        List<Integer> list2;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        No199 no199 = new No199();
        list2=no199.rightSideView(root);

        for (Integer integer : list2) {
            System.out.println(integer);
        }

        System.out.println("=======================================");
        list2=no199.rightSideView(null);
        for (Integer integer : list2) {
            System.out.println(integer);
        }
        System.out.println("=======================================");
        root=new TreeNode(1);
        root.right=new TreeNode(3);
        list2=no199.rightSideView(root);
        for (Integer integer : list2) {
            System.out.println(integer);
        }


    }
}
