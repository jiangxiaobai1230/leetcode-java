package src.pingan;

import java.util.HashSet;

/**
 * @author: Yuan Yuqing
 * @date: 2025-09-13 15:51
 */
public class Solution {
    public int longestConsecutive (int[] nums) {
        // write code here
        HashSet<Integer> hashSet=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hashSet.add(nums[i]);
        }
        int maxLength=0;
        for(int num:hashSet){
            if(!hashSet.contains(num-1)){
                int curNum=num;
                int curLength=1;
                while (hashSet.contains(curNum+1)){
                    curNum++;
                    curLength++;
                }
                maxLength=Math.max(maxLength,curLength);
            }
        }
        return maxLength;

    }
    public static void main(String[] args) {

    }
}
