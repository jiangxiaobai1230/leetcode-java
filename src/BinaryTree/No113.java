package src.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-15 23:26
 */
public class No113 {
    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root==null)return res;
        List<Integer> list=new ArrayList<>();
        traversal(root,list,targetSum);
        return res;

    }
    public void traversal(TreeNode node,List<Integer> list,int target){
        if(node.left==null&&node.right==null){
            target-=node.val;
            if(target==0){
                list.add(node.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            target+=node.val;

            return;
        }
        target-=node.val;
        list.add(node.val);
        if(node.left!=null)traversal(node.left,list,target);

        if(node.right!=null)traversal(node.right,list,target);
        target+=node.val;
        list.remove(list.size()-1);
        return;
    }

    public static void main(String[] args) {

        //输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        //输出：[[5,4,11,2],[5,8,4,5]]
        //示例 2：
        //
        //
        //输入：root = [1,2,3], targetSum = 5
        //输出：[]
        //示例 3：
        //
        //输入：root = [1,2], targetSum = 0
        //输出：[]
        //


    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(4);
    root.right = new TreeNode(8);
    root.left.left = new TreeNode(11);
    root.right.left = new TreeNode(13);
    root.right.right = new TreeNode(4);
    root.left.left.left = new TreeNode(7);
    root.left.left.right = new TreeNode(2);
    root.right.right.left = new TreeNode(5);
    root.right.right.right = new TreeNode(1);
    List<List<Integer>> res = new No113().pathSum(root, 22);
    for (List<Integer> list : res) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
    System.out.println();


    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    List<List<Integer>> res2 = new No113().pathSum(root2, 5);
    for (List<Integer> list : res2) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
    System.out.println();

    TreeNode root3 = new TreeNode(1);
    root3.left = new TreeNode(2);

    List<List<Integer>> res3 = new No113().pathSum(root3, 0);
    for (List<Integer> list : res3) {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
    System.out.println();

    }
}
