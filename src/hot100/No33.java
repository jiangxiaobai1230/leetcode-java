package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-13 15:45
 */
public class No33 {
    //https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/1987503/by-endlesscheng-auuh/?envType=study-plan-v2&envId=top-100-liked



    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-2;
        if(n==1)return nums[0]==target?0:-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>nums[n-1])left=mid+1;
            else right=mid-1;
        }
        if(nums[left]>target)return -1;
        if(left==0){
            int l=0,r=n-1;
            while (l<=r){
                int mmid=(l+r)/2;
                if(nums[mmid]>target)r=mmid-1;
                else if (nums[mmid]<target) l=mmid+1;
                else return mmid;
            }
            if(l>=n||nums[l]!=target)return -1;
        }else {
            if(Math.max(nums[n-1],nums[left-1])<target)return -1;
            if(nums[left]<=target&&target<=nums[n-1]){
                int l=left,r=n-1;
                while (l<=r){
                    int mmid=(l+r)/2;
                    if(nums[mmid]>target)r=mmid-1;
                    else if (nums[mmid]<target) l=mmid+1;
                    else return mmid;
                }
                if(nums[l]!=target)return -1;

            }else if(nums[0]<=target&&target<=nums[left-1]){
                int l=0,r=left-1;
                while (l<=r){
                    int mmid=(l+r)/2;
                    if(nums[mmid]>target)r=mmid-1;
                    else if (nums[mmid]<target) l=mmid+1;
                    else return mmid;
                }
                if(nums[l]!=target)return -1;

            } else {
                return -1;
            }
        }
        return -1;

    }



//    public int search(int[] nums, int target) {
//        if(nums.length==1) {
//            return target==nums[0]?0:-1;
//        }
//        int left=0,right=nums.length-2,mid=0;
//        while (left<=right){
//            mid=(left+right)/2;
//            int num=nums[mid];
//            if(nums[nums.length-1]>num){
//                right=mid-1;
//            }else{
//                left=mid+1;
//
//            }
//        }
//        int index=left;
//        if(target<=nums[nums.length-1]){
//            left=index;
//            right=nums.length-1;
//            while (left<=right){
//                mid=(left+right)/2;
//                int num=nums[mid];
//                if(target==num)return mid;
//                if(target>num){
//                    left=mid+1;
//                }else{
//                    right=mid-1;
//                }
//            }
//            return -1;
//        }
//        else {
//            left=0;
//            right=index-1;
//            while (left<=right){
//                mid=(left+right)/2;
//                int num=nums[mid];
//                if(target==num)return mid;
//                if(target>num){
//                    left=mid+1;
//                }else{
//                    right=mid-1;
//                }
//            }
//            return -1;
//
//        }
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [4,5,6,7,0,1,2], target = 0
        //输出：4
        //示例 2：
        //
        //输入：nums = [4,5,6,7,0,1,2], target = 3
        //输出：-1
        //示例 3：
        //
        //输入：nums = [1], target = 0
        //输出：-1
        int[] nums = {4,5,6,7,0,1,2};
        No33 no33 = new No33();
        System.out.println(no33.search(nums, 0));
        System.out.println(no33.search(nums, 3));

        nums=new int[]{1,3,5};

        System.out.println(no33.search(nums, 3));
    }
}
