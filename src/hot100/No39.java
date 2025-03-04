package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 20:49
 */
public class No39 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer>nums=new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates=candidates;
        dfs(target,0);
        return res;

    }



    private void dfs(int target,int index){
        if(target<0)return;
        if(index>=candidates.length)return;
        if(target==0){
            res.add(new ArrayList<>(nums));
            return;
        }
        dfs(target,index+1);


        nums.add(candidates[index]);
        dfs(target-candidates[index],index);
        nums.remove(nums.size()-1);
//
//        for(int i=index;i<candidates.length;i++){
//            nums.add(candidates[i]);
//            dfs(target-candidates[i],i);
//            nums.remove(nums.size()-1);
//        }


    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：candidates = [2,3,6,7], target = 7
        //输出：[[2,2,3],[7]]
        //解释：
        //2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
        //7 也是一个候选， 7 = 7 。
        //仅有这两种组合。
        //示例 2：
        //
        //输入: candidates = [2,3,5], target = 8
        //输出: [[2,2,2,2],[2,3,3],[3,5]]
        //示例 3：
        //
        //输入: candidates = [2], target = 1
        //输出: []

        No39 no39 = new No39();
        System.out.println(no39.combinationSum(new int[]{2,3,6,7}, 7));
        no39 = new No39();
        System.out.println(no39.combinationSum(new int[]{2,3,5}, 8));
        no39 = new No39();
        System.out.println(no39.combinationSum(new int[]{2}, 1));

    }
}
