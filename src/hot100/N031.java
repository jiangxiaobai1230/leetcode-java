package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 23:50
 */
public class N031 {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int k=n-1;
        while (k>=1&&nums[k-1]>=nums[k])k--;
        if(k==0){
            reverse(nums,0,n-1);
        }else {
            int index=k;
            for(int i=k+1;i<n;i++){
                if(nums[i]>nums[k-1]){
                    if(nums[index]>=nums[i])index=i;
                }
            }

            if(k==n-1){
                reverse(nums,k-1,k);
            }
            else {
                swap(nums,k-1,index);
                reverse(nums,k,n-1);
            }

        }

    }
    void reverse(int[] nums,int i,int j){
        while (i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }

    }
    void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;

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
        int[] nums = {1,3,2};
        N031 n031 = new N031();
        n031.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        nums = new int[]{3,2,1};
        n031.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        nums = new int[]{1,5,1};
        n031.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
