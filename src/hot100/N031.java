package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 23:50
 */
public class N031 {

    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1)return;
        int index=n-1;
        //从右到左找到非递增
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        //找到这个数后从右到左比它大的第一个数，交换
        for(int i=n-1;i>=index+1;i--){
            if(nums[i]>nums[index]){
                swap(nums,i,index);
                break;
            }
        }

        //后面的递增排序.也就是反转
        reverse(nums,index+1,n-1);
        if(index==n-1)reverse(nums,0,n-1);


    }

    void reverse(int[] nums,int i,int j){
        while (i<j){
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
