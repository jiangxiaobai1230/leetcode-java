package src.hot100;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-05 17:11
 */
public class No347 {
    //https://leetcode.cn/problems/top-k-frequent-elements/solutions/581523/zi-jie-ti-ku-347-zhong-deng-qian-kge-gao-pmfl/?envType=study-plan-v2&envId=top-100-liked


    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);

        }

        List<Integer>[] bucket=new List[n+1];
        for(Map.Entry<Integer,Integer> entry: hashMap.entrySet()){
            if(bucket[entry.getValue()]==null){
                bucket[entry.getValue()]=new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());

        }
        int[] res=new int[k];
        int count=0;
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(int j=0;j<bucket[i].size()&&count<k;j++) {
                    res[count++]=bucket[i].get(j);
                }
            }
        }
        return res;
    }

//    public int[] topKFrequent(int[] nums, int k) {
//        HashMap<Integer,Integer> hashMap=new HashMap<>();
//        int n=nums.length;
//        for(int i=0;i<n;i++){
//            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
//
//        }
//
//        Set<Map.Entry<Integer,Integer>> entries=hashMap.entrySet();
//        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue=new PriorityQueue<>((o1,o2)->(o1.getValue()-o2.getValue()));
//
//        for(Map.Entry<Integer,Integer> entry:entries){
//            priorityQueue.add(entry);
//            if(priorityQueue.size()>k){
//                priorityQueue.poll();
//            }
//        }
//        int[] res=new int[k];
//        for(int i=0;i<k;i++){
//            res[i]=priorityQueue.poll().getKey();
//        }
//        return res;
//    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: nums = [1,1,1,2,2,3], k = 2
        //输出: [1,2]
        //示例 2:
        //
        //输入: nums = [1], k = 1
        //输出: [1]

        int[] res1 = new No347().topKFrequent(new int[]{1, 1, 1, 2, 2, 3,3,3}, 2);
        for(int i:res1){
            System.out.println(i);
        }
        System.out.println();
        int[] res2 = new No347().topKFrequent(new int[]{1}, 1);
        for(int i:res2){
            System.out.println(i);
        }

    }
}
