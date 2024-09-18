package src.Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-24 11:17
 */
public class No216 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> nums=new ArrayList<>();
    private int sum=0;


    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k,n,1);
        return res;

    }
    public void backtracking(int k,int n,int count){

        if(sum==n&&nums.size()==k){
            res.add(new ArrayList<>(nums));
            return;
        }

        for(int i=count;i<10;i++){
            nums.add(i);
            sum+=i;
            backtracking(k,n,i+1);
            nums.remove(nums.size()-1);
            sum-=i;
        }

    }
    public static void main(String[] args) {

        //示例 1:
        //
        //输入: k = 3, n = 7
        //输出: [[1,2,4]]
        //解释:
        //1 + 2 + 4 = 7
        //没有其他符合的组合了。
        //示例 2:
        //
        //输入: k = 3, n = 9
        //输出: [[1,2,6], [1,3,5], [2,3,4]]
        //解释:
        //1 + 2 + 6 = 9
        //1 + 3 + 5 = 9
        //2 + 3 + 4 = 9
        //没有其他符合的组合了。
        //示例 3:
        //
        //输入: k = 4, n = 1
        //输出: []
        //解释: 不存在有效的组合。
        int k = 3;
        int n = 7;
        No216 no216 = new No216();
        List<List<Integer>> lists = no216.combinationSum3(k, n);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();

        k=3;
        n=9;
        no216 = new No216();
        lists = no216.combinationSum3(k, n);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println();
        k=4;
        n=1;
        no216 = new No216();
        lists = no216.combinationSum3(k, n);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }


    }
}
