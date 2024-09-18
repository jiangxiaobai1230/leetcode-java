package src.BinaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-05 23:06
 */
public class No637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null)return res;
        deque.offer(root);
        while (!deque.isEmpty()){
            int len=deque.size();
            double tmp=0;
            int count=0;
            while(len>0){
                TreeNode node=deque.pop();
                len--;
                tmp+=node.val;
                count++;
                if(node.left!=null)deque.offer(node.left);
                if(node.right!=null)deque.offer(node.right);

            }
            res.add(tmp/count);
        }

        return res;

    }
    public static void main(String[] args) {
        //输入：root = [3,9,20,null,null,15,7]
        //输出：[3.00000,14.50000,11.00000]
        //解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
        //因此返回 [3, 14.5, 11] 。
        //示例 2:
        //
        //
        //
        //输入：root = [3,9,20,15,7]
        //输出：[3.00000,14.50000,11.00000]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        No637 no637 = new No637();
        List<Double> res = no637.averageOfLevels(root);
        for (Double aDouble : res) {
            System.out.println(aDouble);
        }
        System.out.println("=============");

        root=new TreeNode(3);
        root.left=new TreeNode(9);

        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        res=no637.averageOfLevels(root);
        for (Double aDouble : res) {
            System.out.println(aDouble);
        }

    }
}
