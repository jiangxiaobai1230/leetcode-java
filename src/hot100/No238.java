package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-09 20:12
 */
public class No238 {

    //https://leetcode.cn/problems/product-of-array-except-self/solutions/11472/product-of-array-except-self-shang-san-jiao-xia-sa/?envType=study-plan-v2&envId=top-100-liked
//

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n],suf=new int[n],res=new int[n];
        pre[0]=1;
        suf[n-1]=1;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            res[i]=pre[i]*suf[i];
        }

        return res;

    }

//
//    public int[] productExceptSelf(int[] nums) {
//        int len=nums.length;
//        int[] res=new int[len];
//        int[] pre=new int[len];
//        int[] suf=new int[len];
//        pre[0]=nums[0];
//        suf[len-1]=nums[len-1];
//        for(int i=1;i<len;i++){
//            pre[i]=pre[i-1]*nums[i];
//        }
//        for(int i=len-2;i>=0;i--){
//            suf[i]=suf[i+1]*nums[i];
//        }
//        res[0]=suf[1];
//        res[len-1]=pre[len-2];
//        for (int i=1;i<len-1;i++){
//            res[i]=pre[i-1]*suf[i+1];
//        }
//
//
//        return res;
//    }
//    public int[] productExceptSelf(int[] nums) {
//        int len=nums.length;
//        int[] res=new int[len];
//        res[0]=1;
//        int temp=1;
//        for(int i=1;i<len;i++){
//            res[i]=res[i-1]*nums[i-1];
//        }
//        for(int i=len-2;i>=0;i--){
//            temp*=nums[i+1];
//            res[i]*=temp;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [1,2,3,4]
        //输出: [24,12,8,6]
        //示例 2:
        //
        //输入: nums = [-1,1,0,-3,3]
        //输出: [0,0,9,0,0]
        int[] nums = {1,2,3,4};
        No238 no238 = new No238();
        int[] res=no238.productExceptSelf(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();


        nums = new int[]{-1,1,0,-3,3};
        res=no238.productExceptSelf(nums);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}
