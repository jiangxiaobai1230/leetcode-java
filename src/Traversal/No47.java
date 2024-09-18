package src.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-07 10:43
 */
public class No47 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    private List<Boolean> used=new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        for(int i=0;i<nums.length;i++){
            used.add(false);
        }
        Arrays.sort(nums);
        backtrack(nums);
        return res;

    }
    public void backtrack(int[] nums) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used.get(i))continue;
            if(i>0 && nums[i-1]==nums[i]&& !used.get(i-1)){
                continue;
            }
            used.set(i,true);
            path.add(nums[i]);
            backtrack(nums);
            path.remove(path.size()-1);
            used.set(i,false);
        }

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums = [1,1,2]
        //输出：
        //[[1,1,2],
        // [1,2,1],
        // [2,1,1]]
        //示例 2：
        //
        //输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        int[] nums = {1, 1, 2};
        No47 no47 = new No47();
        List<List<Integer>> lists = no47.permuteUnique(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();

        nums = new int[]{1, 2, 3};
        no47 = new No47();
        lists = no47.permuteUnique(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }
}
