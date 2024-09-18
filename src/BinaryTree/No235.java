package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-19 20:23
 */
public class No235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traversal(root,p,q);

    }

    public TreeNode traversal(TreeNode root,TreeNode p,TreeNode q){
        if(root==null||root== q||root== p)return root;
        if(root.val>p.val&&root.val> q.val)return traversal(root.left,p,q);
        if(root.val<p.val&&root.val< q.val)return traversal(root.right,p,q);
        TreeNode left=traversal(root.left,p,q);
        TreeNode right=traversal(root.right,p,q);
        return root;
    }

    public static void main(String[] args) {

        //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        //输出: 6
        //解释: 节点 2 和节点 8 的最近公共祖先是 6。
        //示例 2:
        //
        //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        //输出: 2
        //解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
        //

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = root.left;
        TreeNode q = root.right;
        System.out.println(new No235().lowestCommonAncestor(root, p, q).getVal());


        p=root.left;
        q=root.left.right;
        System.out.println(new No235().lowestCommonAncestor(root, p, q).getVal());


    }
}
