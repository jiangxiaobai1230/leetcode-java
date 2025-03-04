package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 16:55
 */
public class No46 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer>path=new ArrayList<>();
    private int[] nums;
    private int[] isvisited;
    public List<List<Integer>> permute(int[] nums) {
        this.nums=nums;
        isvisited=new int[nums.length];
        dfs(0);
        return res;

    }
    private void dfs(int index){
        if(index== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(isvisited[i]!=1){
                path.add(nums[i]);
                isvisited[i]=1;
                dfs(index+1);
                path.remove(path.size()-1);
                isvisited[i]=0;
            }

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
        No46 no46 = new No46();
        System.out.println(no46.permute(new int[]{1,2,3}));
        no46 = new No46();
        System.out.println(no46.permute(new int[]{0,1}));
        no46 = new No46();
        System.out.println(no46.permute(new int[]{1}));
    }

}
