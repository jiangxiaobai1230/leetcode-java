package src.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-17 10:08
 */
public class bfs {

    public void bfs(TreeNode root){
        if(root == null){
            System.out.println("null");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

    }
}
