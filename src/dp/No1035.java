package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-13 15:18
 */
public class No1035 {


    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[][] dp=new int[len1+1][len2+1];
        int res=0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                res=Math.max(res,dp[i][j]);
            }

        }
        return res;


    }

    public static void main(String[] args) {
        //输入：nums1 = [1,4,2], nums2 = [1,2,4]
        //输出：2
        //解释：可以画出两条不交叉的线，如上图所示。
        //但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。
        //示例 2：
        //
        //输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
        //输出：3
        //示例 3：
        //
        //输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
        //输出：2

        int[] nums1 = {1,4,2};
        int[] nums2 = {1,2,4};
        No1035 no1035 = new No1035();
        int res = no1035.maxUncrossedLines(nums1, nums2);
        System.out.println(res);
        nums1 = new int[]{2,5,1,2,5};
        nums2 = new int[]{10,5,2,1,5,2};
        res = no1035.maxUncrossedLines(nums1, nums2);
        System.out.println(res);
        nums1 = new int[]{1,3,7,1,7,5};
        nums2 = new int[]{1,9,2,5,1};
        res = no1035.maxUncrossedLines(nums1, nums2);
        System.out.println(res);
    }
}
