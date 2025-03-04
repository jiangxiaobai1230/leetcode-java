package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-23 23:30
 */
public class No235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int num=root.val;
        if(p.val<num&&q.val<num)return lowestCommonAncestor(root.left, p, q);
        if(p.val>num&&q.val>num)return lowestCommonAncestor(root.right, p, q);
        return root;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        //输出: 6
        //解释: 节点 2 和节点 8 的最近公共祖先是 6。
        //示例 2:
        //
        //输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
        //输出: 2
        //解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。

        TreeNode root = new TreeNode(6,new TreeNode(2,new TreeNode(0),new TreeNode(4,new TreeNode(3),new TreeNode(5))),new TreeNode(8,new TreeNode(7),new TreeNode(9)));
        No235 no235 = new No235();
        System.out.println(no235.lowestCommonAncestor(root,new TreeNode(2),new TreeNode(8)).val);
        System.out.println(no235.lowestCommonAncestor(root,new TreeNode(2),new TreeNode(4)).val);

    }
}
