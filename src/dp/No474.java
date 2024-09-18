package src.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-24 23:11
 */
public class No474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int len=strs.length;
        int[][][] dp=new int[len][m+1][n+1];
        List<List<Integer>> nums=new ArrayList<>();
        for(int i=0;i<len;i++){
            List<Integer> num=new ArrayList<>();
            String s=strs[i];
            int zero=0;
            int one=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='0'){
                    zero++;

                }
                else one++;
            }
            num.add(zero);
            num.add(one);
            nums.add(new ArrayList<>(num));
        }
        for(int i=0;i<=m;i++) {
            for (int j = 0; j <= n; j++) {
                if(nums.get(0).get(0)<=i&&nums.get(0).get(1)<=j)
                    dp[0][i][j]=1;
            }

        }


        for(int i=1;i<len;i++){
            int zero=nums.get(i).get(0);
            int one=nums.get(i).get(1);
            for(int j=0;j<=m;j++){
                for(int k=0;k<=n;k++){
                    if(j>=zero&&k>=one)
                        dp[i][j][k]=Math.max(dp[i-1][j][k],dp[i-1][j- zero][k- one]+1);
                    else dp[i][j][k]=dp[i-1][j][k];


                }
            }
        }
        return dp[len-1][m][n];

    }


    public static void main(String[] args) {
        //示例 1：
        //
        //输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
        //输出：4
        //解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
        //其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
        //示例 2：
        //
        //输入：strs = ["10", "0", "1"], m = 1, n = 1
        //输出：2
        //解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(new No474().findMaxForm(strs, m, n));
        System.out.println(new No474().findMaxForm(new String[]{"10", "0", "1"}, 1, 1));


    }
}
