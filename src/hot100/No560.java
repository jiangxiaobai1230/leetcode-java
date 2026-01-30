package src.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-08 18:25
 */
public class No560 {

    public int subarraySum(int[] nums, int k) {
        int len=nums.length;
        if(len==1)return nums[0]==k?1:0;
        int count=0;
        int[] pre=new int[len];
        pre[0]=nums[0];
        for(int i=1;i<len;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<pre.length;i++){
            if(pre[i]==k)count++;
            if(hashMap.containsKey(pre[i]-k)){
                count+=hashMap.get(pre[i]-k);

            }
            hashMap.put(pre[i],hashMap.getOrDefault(pre[i],0)+1);
        }
        return count;

    }


//    public int subarraySum(int[] nums, int k) {
//        int count=0,len=nums.length;
//        if(len==1)return nums[0]==k?1:0;
//        int[] pre=new int[len];
//        pre[0]=nums[0];
//        for(int i=1;i<len;i++){
//            pre[i]=pre[i-1]+nums[i];
//
//        }
//        HashMap<Integer,Integer> hashMap=new HashMap<>();
//        for(int i=0;i<len;i++){
//            if(pre[i]==k)count++;
//            if(hashMap.containsKey(pre[i]-k)){
//                count+=hashMap.getOrDefault(pre[i]-k,0);
//
//            }
//            hashMap.put(pre[i],hashMap.getOrDefault(pre[i],0)+1);
//        }
//        return count;
//    }

//    public int subarraySum(int[] nums, int k) {
//        int count=0,len=nums.length;
//        if(len==1){
//            if(nums[0]==k)count++;
//            return count;
//        }
//        int pre=0;
//        Map<Integer,Integer> map=new HashMap<>();
//        for(int i=0;i<len;i++){
//            pre+=nums[i];
//            if(pre==k)count++;
//            if(map.containsKey(pre-k)){
//                count+=map.get(pre-k);
//            }
//            map.put(pre,map.getOrDefault(pre,0)+1);
//        }
//        return count;
//    }
    public static void main(String[] args) {
        //
        //
        //示例 1：
        //
        //输入：nums = [1,1,1], k = 2
        //输出：2
        //示例 2：
        //
        //输入：nums = [1,2,3], k = 3
        //输出：2
        //

        int[] nums = {-1,-1,1};
        int k = 0;
        No560 no560 = new No560();
        System.out.println(no560.subarraySum(nums, k));
        nums = new int[]{1,2,3};
        k = 3;
        System.out.println(no560.subarraySum(nums, k));


    }
}
