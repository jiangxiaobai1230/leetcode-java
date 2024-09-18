package src.BinaryTree;

import com.sun.source.tree.Tree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-19 19:26
 */
public class No236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root,p,q);

    }
    public TreeNode traversal(TreeNode root,TreeNode p,TreeNode q){

        if(root==null)return null;
        if(root.val== p.val)return p;
        if(root.val== q.val)return q;
        TreeNode left=traversal(root.left,p,q);
        TreeNode right=traversal(root.right,p,q);
        if(left==null && right==null)return null;
        if(left!=null&& right==null)return left;
        if(right!=null && left==null)return right;
        return root;


    }

    public static void main(String[] args) {

        //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        //输出：3
        //解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
        //示例 2：
        //
        //
        //输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        //输出：5
        //解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
        //示例 3：
        //
        //输入：root = [1,2], p = 1, q = 2
        //输出：1
        //

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        No236 no236 = new No236();
        System.out.println(no236.lowestCommonAncestor(root, p, q).val);


        p=new TreeNode(5);
        q=new TreeNode(4);
        System.out.println(no236.lowestCommonAncestor(root, p, q).val);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        p = new TreeNode(1);
        q = new TreeNode(2);
        System.out.println(no236.lowestCommonAncestor(root, p, q).val);



    }
}
