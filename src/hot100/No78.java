package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 15:31
 */
public class No78 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> num=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return res;


    }
    public void dfs(int[] nums,int index){
        if(!res.contains(num)){
            res.add(new ArrayList<>(num));
        }
        for(int i=index;i<nums.length;i++){
            num.add(nums[i]);
            dfs(nums,i+1);
            num.remove(num.size()-1);
        }

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：nums = [1,2,3]
        //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        //示例 2：
        //
        //输入：nums = [0]
        //输出：[[],[0]]
        No78 no78 = new No78();
        System.out.println(no78.subsets(new int[]{1,2,3}));
        no78 = new No78();
        System.out.println(no78.subsets(new int[]{0}));

    }

}
