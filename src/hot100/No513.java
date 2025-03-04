package src.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-24 14:57
 */
public class No513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode node=root;
        queue.add(root);
        while (!queue.isEmpty()){
            node=queue.poll();
            if(node.right!=null) queue.add(node.right);
            if(node.left!=null) queue.add(node.left);


        }
        return node.val;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //
        //
        //输入: root = [2,1,3]
        //输出: 1
        //示例 2:
        //
        //
        //
        //输入: [1,2,3,4,null,5,6,null,null,7]
        //输出: 7
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        No513 no513 = new No513();
        System.out.println(no513.findBottomLeftValue(root));
        root = new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,null,new TreeNode(6,new TreeNode(7),null)));
        System.out.println(no513.findBottomLeftValue(root));
        
    }
}
