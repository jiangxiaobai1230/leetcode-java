package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-11-26 13:36
 */
public class No108 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        int[][] dp=new int[numRows+1][numRows+1];
        for(int i=1;i<=numRows;i++){
            dp[i][1]=1;
            dp[i][i]=1;
        }
        List<Integer> path=new ArrayList<>();
        path.add(1);
        res.add(new ArrayList<>(path));
        if(numRows==1)return res;
        for(int i=2;i<=numRows;i++){
            path=new ArrayList<>();
            path.add(1);
            for(int j=2;j<i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                path.add(dp[i][j]);
            }
            path.add(1);
            res.add(new ArrayList<>(path));
        }

        return res;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: numRows = 5
        //输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        //示例 2:
        //
        //输入: numRows = 1
        //输出: [[1]]

        No108 no108 = new No108();
        List<List<Integer>> res = no108.generate(5);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
        res = no108.generate(1);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();





    }
}
