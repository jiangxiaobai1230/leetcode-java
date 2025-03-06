package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-06 13:20
 */
public class No31 {
    //https://leetcode.cn/problems/next-permutation/solutions/577321/miao-dong-xi-lie-100-cong-xia-yi-ge-pai-gog8j/?envType=study-plan-v2&envId=top-100-liked

    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1)return;
        int k=n-1;
        while (k-1>=0&&nums[k-1]>=nums[k])k--;
        if(k==0){
            reverse(nums,0,n-1);
            return;
        }
        int min_max_index=k;
        while (min_max_index+1<n&&nums[min_max_index+1]>nums[k-1])min_max_index++;
        swap(nums,k-1,min_max_index);
        reverse(nums,k,n-1);

    }
    public void swap(int[] nums,int i,int j){
        int num=nums[i];
        nums[i]=nums[j];
        nums[j]=num;
    }
    public void reverse(int[] nums,int i,int j){
        while (i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,2,3]
        //输出：[1,3,2]
        //示例 2：
        //
        //输入：nums = [3,2,1]
        //输出：[1,2,3]
        //示例 3：
        //
        //输入：nums = [1,1,5]
        //输出：[1,5,1]

        int[] nums=new int[]{1,2,3};
        new No31().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
        nums=new int[]{3,2,1};
        new No31().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
        System.out.println();
        nums=new int[]{1,1,5};
        new No31().nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }

    }
}
