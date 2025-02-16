package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-13 20:48
 */

//https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/2950686/tu-jie-xun-xu-jian-jin-cong-shuang-zhi-z-p2gd/?envType=study-plan-v2&envId=top-100-liked
public class No4MedianOfTwoSortedArrays {



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        if(len1==0&&len2==0)return 0;
        else if(len1==0){
            if(len2%2==0)return (nums2[len2/2]+nums2[len2/2-1])/2.0;
            else return nums2[len2/2];
        }
        else if(len2==0) {
            if(len1%2==0)return (nums1[len1/2]+nums1[len1/2-1])/2.0;
            else return nums1[len1/2];
        }
        if(len1>len2) return findMedianSortedArrays(nums2, nums1);

        int[] a=new int[len1+2];
        int[] b=new int[len2+2];
        a[0]=Integer.MIN_VALUE;
        b[0]=Integer.MIN_VALUE;
        a[len1+1]=Integer.MAX_VALUE;
        b[len2+1]=Integer.MAX_VALUE;
        for(int i=0;i<len1;i++){
            a[i+1]=nums1[i];
        }
        for(int i=0;i<len2;i++){
            b[i+1]=nums2[i];
        }
        int left=0,right=len1+1;
        //开区间
        int totalLeft=(len1+len2+1)/2;
        while (left+1<right){
            int i=(left+right)/2;
            int j=totalLeft-i;
            if(a[i]>b[j+1]){
                right=i;
            }else left=i;
        }
        int i=left;
        int j=totalLeft-i;
        if((len1+len2)%2==0)return (Math.max(a[i],b[j])+Math.min(a[i+1],b[j+1]))/2.0;
        else return Math.max(a[i],b[j]);


    }
    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums1 = [1,3], nums2 = [2]
        //输出：2.00000
        //解释：合并数组 = [1,2,3] ，中位数 2
        //示例 2：
        //
        //输入：nums1 = [1,2], nums2 = [3,4]
        //输出：2.50000
        //解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        //
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        No4MedianOfTwoSortedArrays no4MedianOfTwoSortedArrays = new No4MedianOfTwoSortedArrays();
        double res = no4MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
        nums1=new int[]{1,2};
        nums2=new int[]{3,4};
        res = no4MedianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);

    }
}
