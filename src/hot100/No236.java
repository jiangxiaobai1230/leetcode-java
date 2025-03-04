package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-23 14:21
 */
public class No236 {
    //https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/2023872/fen-lei-tao-lun-luan-ru-ma-yi-ge-shi-pin-2r95/comments/2472298


    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 代码通过返回值来判定查找结果且只有三种可能：null/两个目标结点之一/公共祖先
         * 对于第一个if条件判别，在这里找到目标结点就返回，因为如果另一个目标结点在更深处，
         * 则说明当前结点即为最近公共祖先，直接返回没问题。如果在另一个目标结点另一棵子树上，
         * 则没必要继续查找，也应该直接返回。
         */
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        /**
         * 如果左右结点同时出现，则说明找到了公共祖先，返回当前节点即可。
         * 因为是采用后根遍历，可以保证找到的一定是最近公共祖先
         */
        if (left != null && right != null) {
            return root;
        }
        /**
         * 在没完全找到的情况下返回，在这种情况下可分为两种可能：
         * 1.只找到一个目标结点，则返回left和right中非null的一个
         * 2.一个都没有找到，则left = right = null，返回null
         */
        return left != null ? left : right;
    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null||root==p||root==q)return root;
//        TreeNode left=lowestCommonAncestor(root.left,p,q);
//        TreeNode right=lowestCommonAncestor(root.right,p,q);
//        if(left!=null&&right!=null)return root;
//        if(left!=null)return left;
//        if(right!=null)return right;
//        else return null;
//
//    }

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
        TreeNode root = new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(0),new TreeNode(8)));
        No236 no236 = new No236();
        System.out.println(no236.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(1)).val);
        System.out.println(no236.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(4)).val);
        root = new TreeNode(1,new TreeNode(2),null);
        System.out.println(no236.lowestCommonAncestor(root,new TreeNode(1),new TreeNode(2)).val);


    }
}
