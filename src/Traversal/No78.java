package src.Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-29 22:48
 */
public class No78 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        if(nums.length==0){
            return res;
        }
        backtracking(nums,0);
        return res;
    }
    public void backtracking(int[] nums,int index){
//        if(index>=nums.length){
//            res.add(new ArrayList<>(path));
//            return;
//        }
        for(int i=index;i<nums.length;i++){
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracking(nums,i+1);
            path.remove(path.size()-1);

        }
        return;

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
        //
        //
        //提示：

        int[] nums = {1,2,3};
        No78 no78 = new No78();
        List<List<Integer>> subsets = no78.subsets(nums);
        for (int i = 0; i < subsets.size(); i++) {
            System.out.println(subsets.get(i));
        }
        System.out.println();

        int[] nums2 = {0};
        no78 = new No78();
        List<List<Integer>> subsets2 = no78.subsets(nums2);
        for (int i = 0; i < subsets2.size(); i++) {
            System.out.println(subsets2.get(i));
        }


    }

}
