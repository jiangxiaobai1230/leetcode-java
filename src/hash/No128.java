package src.hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: Yuan Yuqing
 * @date: 2024-10-20 23:29
 */
public class No128 {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0)return 0;
        HashSet<Integer> hashSet=new HashSet<>();
        int res=1;
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        for(Integer num:hashSet){
            if(!hashSet.contains(num-1)){
                int count=1;
                while (hashSet.contains(num+count)){
                    count++;
                }
                res=Math.max(res,count);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums = [100,4,200,1,3,2]
        //输出：4
        //解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
        //示例 2：
        //
        //输入：nums = [0,3,7,2,5,8,4,6,0,1]
        //输出：9
        int[] nums = {100,4,200,1,3,2};
        No128 no128 = new No128();
        System.out.println(no128.longestConsecutive(nums));
        nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(no128.longestConsecutive(nums));
    }
}
