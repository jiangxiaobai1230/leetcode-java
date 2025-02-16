package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 23:14
 */

///https://leetcode.cn/problems/sort-colors/solutions/676745/zui-jian-ji-de-shuang-zhi-zhen-jie-fa-yi-gtfz/?envType=study-plan-v2&envId=top-100-liked
    //https://leetcode.cn/problems/sort-colors/solutions/1868577/by-ac_oier-7lwk/?envType=study-plan-v2&envId=top-100-liked
public class No75 {
    public void sortColors(int[] nums) {
        int n=nums.length;
        if(n<2)return;
        int l=0,r=n-1,i=0;
        while (i<=r){
            if(nums[i]==0){
                int temp=nums[l];
                nums[l]=nums[i];
                nums[i]=temp;
                l++;
                i++;
            } else if (nums[i]==1) {
                i++;
            }else {
                int temp=nums[r];
                nums[r]=nums[i];
                nums[i]=temp;
                r--;
//                i++;
            }
        }
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [2,0,2,1,1,0]
        //输出：[0,0,1,1,2,2]
        //示例 2：
        //
        //输入：nums = [2,0,1]
        //输出：[0,1,2]
        int[] nums = new int[]{1,2,0};
        No75 no75 = new No75();
        no75.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        nums = new int[]{2,0,1};
        no75.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
