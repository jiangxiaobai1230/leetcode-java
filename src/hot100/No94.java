package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 23:18
 */
public class No94 {
    private List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }
    public void dfs(TreeNode root){
        if(root==null)return;
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);

    }

    public static void main(String[] args) {
        //输入：root = [1,null,2,3]
        //输出：[1,3,2]
        //示例 2：
        //
        //输入：root = []
        //输出：[]
        //示例 3：
        //
        //输入：root = [1]
        //输出：[1]

        TreeNode root1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode root2 = new TreeNode();
        TreeNode root3 = new TreeNode(1);
        List<Integer> res1 = new No94().inorderTraversal(root1);
        List<Integer> res2 = new No94().inorderTraversal(root2);
        List<Integer> res3 = new No94().inorderTraversal(root3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
