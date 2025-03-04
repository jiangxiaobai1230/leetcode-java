package src.hot100;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-26 21:55
 */
public class No77 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> tmp=new LinkedList<>() {
    };
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k);
        return res;
    }
    public void dfs(int n, int k){
        int d=k-tmp.size();
        if(d==0){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=n;i>=d;i--){
            tmp.add(i);
            dfs(i-1,k);
            tmp.remove(tmp.size()-1);

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
        No77 no77 = new No77();
        System.out.println(no77.combine(4,2));
        no77 = new No77();
        System.out.println(no77.combine(1,1));


    }
}
