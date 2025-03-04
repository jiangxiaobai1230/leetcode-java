package src.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-23 23:46
 */
public class No102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (queue.size()!=0){
            List<Integer> floor=new ArrayList<>();
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode node=queue.poll();
                floor.add(node.val);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            res.add(new ArrayList<>(floor));

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

        TreeNode root = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        No102 no102 = new No102();
        System.out.println(no102.levelOrder(root));
        root = new TreeNode(1);
        System.out.println(no102.levelOrder(root));
        root = null;
        System.out.println(no102.levelOrder(root));

    }
}
