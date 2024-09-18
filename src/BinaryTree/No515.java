package src.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-06 23:06
 */
public class No515 {

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList();
        if(root==null)return res;
        deque.offer(root);
        while (!deque.isEmpty()){
            int len=deque.size();
            int maxNum=Integer.MIN_VALUE;
            while (len>0){
                TreeNode node=deque.pop();
                len--;
                if(node.val>maxNum)maxNum=node.val;
                if(node.left!=null)deque.offer(node.left);
                if(node.right!=null)deque.offer(node.right);

            }
            res.add(maxNum);


        }
        return res;

    }
    public static void main(String[] args) {

        //输入: root = [1,3,2,5,3,null,9]
        //输出: [1,3,9]
        //示例2：
        //
        //输入: root = [1,2,3]
        //输出: [1,3]
        //

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        No515 no515 = new No515();
        List<Integer> list =no515.largestValues(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("====================");

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        list=no515.largestValues(root2);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
