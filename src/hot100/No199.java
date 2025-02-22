package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 20:22
 */
public class No199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)return res;
        dfs(root,0,res);
        return res;
    }
    public void dfs(TreeNode root,int depth,List<Integer> res){
        if(root==null)return;
        if(depth==res.size())res.add(root.val);
        dfs(root.right,depth+1,res);
        dfs(root.left,depth+1,res);

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：root = [1,2,3,null,5,null,4]
        //
        //输出：[1,3,4]
        //
        //解释：
        //
        //
        //
        //示例 2：
        //
        //输入：root = [1,2,3,4,null,null,null,5]
        //
        //输出：[1,3,4,5]
        //
        //解释：
        //
        //
        //
        //示例 3：
        //
        //输入：root = [1,null,3]
        //
        //输出：[1,3]
        //
        //示例 4：
        //
        //输入：root = []
        //
        //输出：[]
        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(5)),new TreeNode(3,null,new TreeNode(4)));
        No199 no199 = new No199();
        System.out.println(no199.rightSideView(root));
        root = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,null,new TreeNode(5)));
        System.out.println(no199.rightSideView(root));
        root = new TreeNode(1,null,new TreeNode(3));
        System.out.println(no199.rightSideView(root));
        root = null;
        System.out.println(no199.rightSideView(root));

    }

}
