package src.Traversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-30 10:33
 */
public class No491 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer>path=new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums.length<2)return res;
        backtracking(nums,0);
        return res;

    }
    public void backtracking(int[] nums,int index){
        if(path.size()>=2){
            res.add(new ArrayList<>(path));
        }
        HashSet<Integer> used=new HashSet<>();
        for(int i=index;i<nums.length;i++){
            if((path.isEmpty()||nums[i]>=path.get(path.size()-1))&&!used.contains(nums[i])){
                used.add(nums[i]);
                path.add(nums[i]);
                backtracking(nums,i+1);
                path.remove(path.size()-1);
            }

        }

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：nums = [4,6,7,7]
        //输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        //示例 2：
        //
        //输入：nums = [4,4,3,2,1]
        //输出：[[4,4]]

        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        No491 no491 = new No491();
        List<List<Integer>> subsequences = no491.findSubsequences(nums);
        for (List<Integer> list : subsequences) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
//        System.out.println(subsequences.size());

//        int[] nums2 = {4,4,3,2,1};
//        no491 = new No491();
//        List<List<Integer>> subsequences2 = no491.findSubsequences(nums2);
//        for (List<Integer> list : subsequences2) {
//            for (Integer integer : list) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
//        }

    }

}
