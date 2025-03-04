package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 13:58
 */
public class No72 {
    public int minDistance(String word1, String word2) {
        if(word1.length()<word2.length()){
            String temp=word1;
            word1=word2;
            word2=temp;
        }
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<m;i++){
           for(int j=0;j<n;j++){
               if(word1.charAt(i)==word2.charAt(j)){
                   dp[i+1][j+1]=dp[i][j];
               }else {
                   dp[i+1][j+1]=Math.min(dp[i][j],Math.min(dp[i+1][j],dp[i][j+1]))+1;
               }
           }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：word1 = "horse", word2 = "ros"
        //输出：3
        //解释：
        //horse -> rorse (将 'h' 替换为 'r')
        //rorse -> rose (删除 'r')
        //rose -> ros (删除 'e')
        //示例 2：
        //
        //输入：word1 = "intention", word2 = "execution"
        //输出：5
        //解释：
        //intention -> inention (删除 't')
        //inention -> enention (将 'i' 替换为 'e')
        //enention -> exention (将 'n' 替换为 'x')
        //exention -> exection (将 'n' 替换为 'c')
        //exection -> execution (插入 'u')
        System.out.println(new No72().minDistance("horse", "ros"));
        System.out.println(new No72().minDistance("intention", "execution"));

    }
}
