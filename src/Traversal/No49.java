package src.Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-07 10:19
 */
public class No49 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    private List<Boolean> used=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for(int i=0;i<nums.length;i++){
            used.add(false);
        }
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
        //输入：nums = [1,2,3]
        //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        //示例 2：
        //
        //输入：nums = [0,1]
        //输出：[[0,1],[1,0]]
        //示例 3：
        //
        //输入：nums = [1]
        //输出：[[1]]

        int[] nums = {1, 2, 3};
        No49 no49 = new No49();
        List<List<Integer>> permute = no49.permute(nums);
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[] nums2 = {0, 1};
        no49 = new No49();
        List<List<Integer>> permute2 = no49.permute(nums2);
        for (List<Integer> list : permute2) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[] nums3 = {1};
        no49 = new No49();
        List<List<Integer>> permute3 = no49.permute(nums3);
        for (List<Integer> list : permute3) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
