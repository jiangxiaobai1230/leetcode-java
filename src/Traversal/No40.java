package src.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-25 10:59
 */
public class No40 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> sumList=new ArrayList<>();
    private int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0);
        return res;

    }
    public void backtracking(int[] candidates,int target,int index){
        if(sum==target){
            if(!res.contains(sumList))
                res.add(new ArrayList<>(sumList));
            return;
        }
        if(sum>target)return;
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i-1]==candidates[i])continue;
            sum+=candidates[i];
            sumList.add(candidates[i]);
            backtracking(candidates,target,i+1);
            sum-=candidates[i];
            sumList.remove(sumList.size()-1);
        }
    }
    public static void main(String[] args) {

        //示例 1:
        //
        //输入: candidates = [10,1,2,7,6,1,5], target = 8,
        //输出:
        //[
        //[1,1,6],
        //[1,2,5],
        //[1,7],
        //[2,6]
        //]
        //示例 2:
        //
        //输入: candidates = [2,5,2,1,2], target = 5,
        //输出:
        //[
        //[1,2,2],
        //[5]
        //]

        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        No40 no40 = new No40();
        List<List<Integer>> lists = no40.combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();

        candidates = new int[]{2,5,2,1,2};
        target = 5;
        lists = no40.combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();



    }
}
