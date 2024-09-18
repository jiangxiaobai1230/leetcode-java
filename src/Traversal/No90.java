package src.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-30 10:14
 */
public class No90 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums,0);
        return res;

    }
    public void backtracking(int[] nums,int index){

        res.add(new ArrayList<>(path));
        if(index>=nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i-1]==nums[i]){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.remove(path.size()-1);
        }

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums = [1,2,2]
        //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
        //示例 2：
        //
        //输入：nums = [0]
        //输出：[[],[0]]

        int[] nums = {1,2,2};
        No90 no90 = new No90();
        List<List<Integer>> lists = no90.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[] nums2 = {0};
        no90 = new No90();
        List<List<Integer>> lists2 = no90.subsetsWithDup(nums2);
        for (List<Integer> list : lists2) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }



    }
}
