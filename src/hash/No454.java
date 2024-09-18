package src.hash;

import javax.management.MBeanAttributeInfo;
import java.util.HashMap;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-20 11:28
 */
public class No454 {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        HashMap<Integer,Integer>hashMapAB=new HashMap<>();
        int count=0;

        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                hashMapAB.put(nums1[i]+nums2[j], hashMapAB.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                int sum=nums3[i]+nums4[j];
                count+=hashMapAB.getOrDefault(-sum,0);

            }
        }

        return count;

    }

//    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//
//        HashMap<Integer,Integer>hashMapAB=new HashMap<>();
//        HashMap<Integer,Integer>hashMapCD=new HashMap<>();
//        int count=0;
//
//        for(int i=0;i<nums1.length;i++){
//            for(int j=0;j<nums2.length;j++){
//                hashMapAB.put(nums1[i]+nums2[j], hashMapAB.getOrDefault(nums1[i]+nums2[j],0)+1);
//            }
//        }
//        for(int i=0;i<nums3.length;i++){
//            for(int j=0;j<nums4.length;j++){
//                hashMapCD.put(-nums3[i]-nums4[j], hashMapCD.getOrDefault(-nums3[i]-nums4[j],0)+1);
//            }
//        }
//        for (int val:hashMapAB.keySet()) {
//            if(hashMapCD.containsKey(val)){
//                count+=hashMapCD.get(val)*hashMapAB.get(val);
//            }
//
//        }
//        return count;
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
        //输出：2
        //解释：
        //两个元组如下：
        //1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
        //2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
        //示例 2：
        //
        //输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
        //输出：1
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
        No454 no454 = new No454();
        System.out.println(no454.fourSumCount(nums1, nums2, nums3, nums4));

        int[] nums11 = new int[]{-1,-1};
        int[] nums21 = new int[]{-1,1};
        int[] nums31 = new int[]{-1,1};
        int[] nums41 = new int[]{1,-1};
        System.out.println(no454.fourSumCount(nums11, nums21, nums31, nums41));

        //[-1,-1]
        //[-1,1]
        //[-1,1]
        //[1,-1]



    }
}
