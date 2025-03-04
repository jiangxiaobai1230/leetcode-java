package src.hot100;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-02 23:28
 */
public class No118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        int[][] dp=new int[numRows+1][numRows+1];
        dp[1][1]=1;
        List<Integer> nums=new ArrayList<>();
        nums.add(1);
        res.add(new ArrayList<>(nums));
        if(numRows==1){
            return res;
        }
        for(int i=2;i<=numRows;i++){
            nums=new ArrayList<>();
            for(int j=1;j<=numRows;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                if(dp[i][j]!=0)nums.add(dp[i][j]);
            }
            res.add(new ArrayList<>(nums));
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

        int numRows = 5;
        List<List<Integer>> res = new No118().generate(numRows);
        System.out.println(res);
        numRows = 1;
        res = new No118().generate(numRows);
        System.out.println(res);

    }
}
