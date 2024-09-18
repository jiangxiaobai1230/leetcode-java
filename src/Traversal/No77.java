package src.Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-24 10:53
 */
public class No77 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> temp=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if(n<k)return null;
        backtracking(n,k,1);
        return res;

    }
    public void backtracking(int n, int k,int count){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=count;i<=n;i++){
            temp.add(i);
            backtracking(n,k,i+1);
            temp.remove(temp.size()-1);
        }


    }



    public static void main(String[] args) {
        //示例 1：
        //
        //输入：n = 4, k = 2
        //输出：
        //[
        //  [2,4],
        //  [3,4],
        //  [2,3],
        //  [1,2],
        //  [1,3],
        //  [1,4],
        //]
        //示例 2：
        //
        //输入：n = 1, k = 1
        //输出：[[1]]
        //

        int n=4;
        int k=2;
        No77 no77 = new No77();
        List<List<Integer>> combine = no77.combine(n, k);
        for (int i = 0; i < combine.size(); i++) {
            for (int j = 0; j < combine.get(i).size(); j++) {
                System.out.print(combine.get(i).get(j)+" ");
            }
            System.out.println();

        }
        System.out.println();


        n=1;
        k=1;
        combine = no77.combine(n, k);
        for (int i = 0; i < combine.size(); i++) {
            for (int j = 0; j < combine.get(i).size(); j++) {
                System.out.print(combine.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
