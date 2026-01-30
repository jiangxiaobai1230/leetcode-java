package src.hot100;

import src.dp.TreeNode;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2025-10-07 17:02
 */
public class No103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        queue.add(root);
        int flag=0;
        while (!queue.isEmpty()){
            List<Integer> floor=new ArrayList<>();
            int size= queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                floor.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);

            }
            if(flag==0){
                res.add(new ArrayList<>(floor));
                flag=1;
            }else {
                Collections.reverse(floor);
                res.add(new ArrayList<>(floor));
                flag=0;
            }


        }

        return res;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：root = [3,9,20,null,null,15,7]
        //输出：[[3],[20,9],[15,7]]
        //示例 2：
        //
        //输入：root = [1]
        //输出：[[1]]
        //示例 3：
        //
        //输入：root = []
        //输出：[]
        No103 no103 = new No103();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        List<List<Integer>> lists = no103.zigzagLevelOrder(node1);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();

        }
        TreeNode node = null;
        lists = no103.zigzagLevelOrder(node);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();

        }
        TreeNode nodee=new TreeNode(1);
        lists = no103.zigzagLevelOrder(nodee);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
