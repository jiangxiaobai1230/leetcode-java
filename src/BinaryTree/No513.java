package src.BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-12 22:35
 */
public class No513 {
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null&&root.right==null) return root.val;
        Deque<TreeNode> deque=new LinkedList<>();
        int res=root.val;
        TreeNode node=root;
        deque.offer(root);
        while (!deque.isEmpty()){
            node =deque.pop();
            if(node.left==null&&node.right==null){
                res= node.val;

            }
            if(node.right!=null)deque.offer(node.right);
            if(node.left!=null)deque.offer(node.left);

        }
        return res;


    }

    public static void main(String[] args) {

        //输入: root = [2,1,3]
        //输出: 1
        //示例 2:
        //
        //
        //
        //输入: [1,2,3,4,null,5,6,null,null,7]
        //输出: 7
        //

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(new No513().findBottomLeftValue(root));
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.left=new TreeNode(5);
        root2.right.right=new TreeNode(6);
        root2.right.left.left=new TreeNode(7);

        System.out.println(new No513().findBottomLeftValue(root2));



    }
}
