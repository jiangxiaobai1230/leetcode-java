package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-23 10:34
 */
public class No108 {
    public TreeNode sortedArrayToBST(int[] nums) {

        return buildTree(nums,0,nums.length-1);
    }
    public TreeNode buildTree(int[] nums,int begin,int end){
        if(begin>end)return null;
        int mid=(begin+end)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(nums,begin,mid-1);
        root.right=buildTree(nums,mid+1,end);
        return root;

    }

    public static void main(String[] args) {

        //输入：nums = [-10,-3,0,5,9]
        //输出：[0,-3,9,-10,null,5]
        //解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
        //
        //示例 2：
        //
        //
        //输入：nums = [1,3]
        //输出：[3,1]
        //解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。

        No108 no108 = new No108();
        TreeNode treeNode = no108.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        bfs bfs= new bfs();
        bfs.bfs(treeNode);
        System.out.println("=====");

        treeNode= no108.sortedArrayToBST(new int[]{1, 3});
        bfs.bfs(treeNode);


    }
}
