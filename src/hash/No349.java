package src.hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-19 09:04
 */
public class No349 {


    public int[] intersection(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        HashSet<Integer>res=new HashSet<>();
        if(len1==0||len2==0){
            return new int[0];

        }
        HashSet<Integer> set1=new HashSet<>();
//        HashSet<Integer> set2=new HashSet<>();
        for(int i=0;i<len1;i++){
            set1.add(nums1[i]);
        }

        for(int i=0;i<len2;i++){
            if(set1.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
//        for(int i=0;i<len2;i++){
//            set2.add(nums2[i]);
//        }
//
//        if(set1.size()< set2.size()){
//            HashSet<Integer> set3=set2;
//            set2=set1;
//            set1=set3;
//        }
//        for (int val:set1) {
//            if(set2.contains(val)){
//                res.add(val);
//
//            }
//
//
//        }
//        int[] resList=new int[res.size()];
//        int index=0;
//        for(int val:res){
//            resList[index++]=val;
//        }
//
//        return resList;


        return res.stream().mapToInt(x->x).toArray();

    }

    public static void main(String[] args) {


        //示例 1：
        //
        //输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2]
        //示例 2：
        //
        //输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        //输出：[9,4]
        //解释：[4,9] 也是可通过的



        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        No349 no349 = new No349();
        int[] result = no349.intersection(nums1, nums2);
        for (int val:
             result) {
            System.out.println(val);

        }
        System.out.println();


        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};

        result = no349.intersection(nums1, nums2);
        for (int val:
                result) {
            System.out.println(val);

        }


    }
}
