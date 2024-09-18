package src.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-04 23:14
 */
public class No102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res=new ArrayList<>();


        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null)return res;
        deque.offer(root);
        while (deque.size()!=0) {
            int len=deque.size();
            List<Integer> tempList = new ArrayList<>();
            while (len != 0) {

                TreeNode node = deque.pop();
                tempList.add(node.val);
                len--;
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);


            }
            res.add(tempList);
        }

        return res;


    }

    public static void main(String[] args) {

        //输入：root = [3,9,20,null,null,15,7]
        //输出：[[3],[9,20],[15,7]]
        //示例 2：
        //
        //输入：root = [1]
        //输出：[[1]]
        //示例 3：
        //
        //输入：root = []
        //输出：[]
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>>list = new No102().levelOrder(root);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();


        root=new TreeNode(1);
        list = new No102().levelOrder(root);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();

        root=null;
        list = new No102().levelOrder(root);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print("");
            }
        }
        System.out.println();


    }
}
