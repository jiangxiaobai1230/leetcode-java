package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 23:28
 */
public class No108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    public TreeNode buildTree(int[] nums,int i,int j){
        if(i>j)return null;
        int mid=(i+j)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(nums,i,mid-1);
        root.right=buildTree(nums,mid+1,j);
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
        int[] nums1 = {-10, -3, 0, 5, 9};
        int[] nums2 = {1, 3};
        TreeNode res1 = new No108().sortedArrayToBST(nums1);
        TreeNode res2 = new No108().sortedArrayToBST(nums2);
        while (res1 != null) {
            System.out.println(res1.val);
            res1 = res1.left;
        }
        System.out.println();
        while (res2 != null) {
            System.out.println(res2.val);
            res2 = res2.left;
        }

    }
}
