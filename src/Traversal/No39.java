package src.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-25 10:29
 */
public class No39 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> sumList=new ArrayList<>();
    private int sum=0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates,target,0);
//        Arrays.sort(candidates);
        return res;

    }
    public void backtracking(int[] candidates,int target,int index){
        if(sum==target){
            res.add(new ArrayList<>(sumList));
            return;
        }
        if(sum>target)return;

        for(int i=index;i<candidates.length;i++){
            sum+=candidates[i];
            sumList.add(candidates[i]);
            backtracking(candidates,target,i);
            sumList.remove(sumList.size()-1);
            sum-=candidates[i];
        }

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

        int[] candidates = {2,3,6,7};
        int target = 7;
        No39 no39 = new No39();
        List<List<Integer>> lists = no39.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        candidates = new int[]{2,3,5};
        target = 8;
        no39 = new No39();
        lists = no39.combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

        candidates = new int[]{2};
        target = 1;
        no39 = new No39();
        lists = no39.combinationSum(candidates, target);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }



    }
}
