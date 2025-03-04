package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-23 10:59
 */
public class No98 {

    //https://leetcode.cn/problems/validate-binary-search-tree/solutions/2020306/qian-xu-zhong-xu-hou-xu-san-chong-fang-f-yxvh/



//    public boolean isValidBST(TreeNode root) {
//        return dfs(root)[1]!=Long.MAX_VALUE;
//
//    }
//
//    private long[] dfs(TreeNode node) {
//        if(node==null)return new long[]{Long.MAX_VALUE,Long.MIN_VALUE};
//        long[] left=dfs(node.left);
//        long[] right=dfs(node.right);
//        long x= node.val;
//        // 也可以在递归完左子树之后立刻判断，如果发现不是二叉搜索树，就不用递归右子树了
//        if (x <= left[1] || x >= right[0]) {
//            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
//        }
//        return new long[]{Math.min(left[0],x),Math.max(right[1],x)};
//
//
//    }

    private long pre=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        if(!isValidBST(root.left))return false;
        if(root.val<=pre)return false;
        pre=root.val;
        return isValidBST(root.right);


    }


//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean isValidBST(TreeNode root, long left, long right) {
//        if(root==null)return true;
//        int x=root.val;
//        return left<x&&x<right&&isValidBST(root.left,left,x)&&isValidBST(root.right,x,right);
//
//
//    }


//    public boolean isValidBST(TreeNode root) {
//        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean isValidBST(TreeNode root, long left, long right) {
//        if(root==null)return true;
//        long x=root.val;
//        return left<x&&x<right&&isValidBST(root.left,left,x)&&isValidBST(root.right,x,right);
//
//    }





//    private long pre=Integer.MIN_VALUE;
//    public boolean isValidBST(TreeNode root) {
//        if(root==null)return true;
//        if(isValidBST(root.left)){
//            if(root.val<pre)return false;
//        }else return false;
//        pre=root.val;
//        return isValidBST(root.right);
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：root = [2,1,3]
        //输出：true
        //示例 2：
        //
        //
        //输入：root = [5,1,4,null,null,3,6]
        //输出：false
        //解释：根节点的值是 5 ，但是右子节点的值是 4 。
        TreeNode root = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        No98 no98 = new No98();
        System.out.println(no98.isValidBST(root));
        root = new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        System.out.println(no98.isValidBST(root));

    }
}
