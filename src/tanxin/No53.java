package src.tanxin;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-11 10:45
 */
public class No53 {

    public int maxSubArray(int[] nums) {
        if(nums.length==1)return nums[0];
        int sum=Integer.MIN_VALUE,count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            sum=Math.max(sum,count);
            if(count<0){
                count=0;
            }
        }
        return sum;



    }
//    public int maxSubArray(int[] nums) {
//        int len=nums.length;
//        if(len==1)return nums[0];
//        int sum=Integer.MIN_VALUE,count=0,maxSum=Integer.MIN_VALUE,isZero=0,max=Integer.MIN_VALUE;
//        for(int i=0;i<len;i++){
//            int num=nums[i];
//            if(num>max)max=num;
//            if(sum>maxSum)maxSum=sum;
//            if(num<0&&count==0){
//                continue;
//            }
//            if(num==0)isZero=1;
//            if(num>0&&count==0){
//                sum=0;
//                count++;
//                sum+=num;
//                if(sum>maxSum)maxSum=sum;
//                continue;
//            }
//            if(num<0&&count>0){
//                sum+=num;
//                count++;
//                continue;
//            }
//            if(num>0){
//                if(sum<0&&sum<num){
//                    sum=num;
//                    count=1;
//                    if(sum>maxSum)maxSum=sum;
//                }else {
//                    sum+=num;
//                    count++;
//                    if(sum>maxSum)maxSum=sum;
//                }
//            }
//
//
//
//        }
//        if(maxSum==Integer.MIN_VALUE&&isZero==0){
//            return max;
//        }
//        if(maxSum==Integer.MIN_VALUE&&isZero==1)return 0;
//        return maxSum;
//
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        //解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
        //示例 2：
        //
        //输入：nums = [1]
        //输出：1
        //示例 3：
        //
        //输入：nums = [5,4,-1,7,8]
        //输出：23
        int[] nums = new int[]{-1,0};
        System.out.println(new No53().maxSubArray(nums));
        System.out.println(new No53().maxSubArray(new int[]{1}));
        System.out.println(new No53().maxSubArray(new int[]{5,4,-1,7,8}));

    }

}
