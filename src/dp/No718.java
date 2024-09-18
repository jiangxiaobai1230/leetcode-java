package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-12 15:21
 */
public class No718 {

    public int findLength(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[][] dp=new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j] =dp[i-1][j-1];
                }
            }
        }
        return dp[len1][len2];


    }

//    public int findLength(int[] nums1, int[] nums2) {
//        int len1=nums1.length;
//        int len2=nums2.length;
//        int[][] dp=new int[len1+1][len2+1];
//        int res=0;
//        for(int i=1;i<=len1;i++){
//            for(int j=1;j<=len2;j++){
//                if(nums1[i-1]==nums2[j-1]){
//                    dp[i][j]=dp[i-1][j-1]+1;
//                }else {
//                    dp[i][j] =0;
//                }
//                res=Math.max(res,dp[i][j]);
//            }
//
//        }
//        return res;
//
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
        //输出：3
        //解释：长度最长的公共子数组是 [3,2,1] 。
        //示例 2：
        //
        //输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
        //输出：5
        //

        No718 no718 = new No718();
        int[] nums1 = new int[]{0,1,1,1,1};
        int[] nums2 = new int[]{1,0,1,0,1};
        System.out.println(no718.findLength(nums1, nums2));
        nums1= new int[]{0,0,0,0,0};
        nums2 = new int[]{0,0,0,0,0};
        System.out.println(no718.findLength(nums1,nums2));
    }
}
