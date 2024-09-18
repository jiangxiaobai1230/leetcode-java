package src.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-31 17:09
 */
public class No347 {

    public int[] topKFrequent(int[] nums, int k) {

        int[] res=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        int n= nums.length;
        //统计次数
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //进行排序
        PriorityQueue<int[]> pd=new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(pd.size()<k){
                pd.add(new int[]{entry.getKey(),entry.getValue()});
            } else if (pd.peek()[1]<entry.getValue()) {
                pd.poll();
                pd.add(new int[]{entry.getKey(),entry.getValue()});
            }

        }

        //取出结果
        for(int i=0;i<k;i++){
            res[i]=pd.poll()[0];
        }
        return res;

    }
    public static void main(String[] args) {
        //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
        //
        //
        //
        //示例 1:
        //
        //输入: nums = [1,1,1,2,2,3], k = 2
        //输出: [1,2]
        //示例 2:
        //
        //输入: nums = [1], k = 1
        //输出: [1]


        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        No347 no347 = new No347();
        int[] ints = no347.topKFrequent(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        nums=new int[]{1};
        k=1;
        ints = no347.topKFrequent(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }



    }
}
