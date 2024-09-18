package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-18 19:26
 */
public class No115 {
    public int numDistinct(String s, String t) {
        int len1=s.length(),len2=t.length();
        int[][] dp=new int[len1+1][len2+1];
        //dp[i][0]表示什么呢？
        //
        //dp[i][0] 表示：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。
        //
        //那么dp[i][0]一定都是1，因为也就是把以i-1为结尾的s，删除所有元素，出现空字符串的个数就是1。
        //
        //再来看dp[0][j]，dp[0][j]：空字符串s可以随便删除元素，出现以j-1为结尾的字符串t的个数。
        //
        //那么dp[0][j]一定都是0，s如论如何也变成不了t。
        for(int i=0;i<=len1;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else dp[i][j]=dp[i-1][j];
            }
        }


        return dp[len1][len2];

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：s = "rabbbit", t = "rabbit"
        //输出：3
        //解释：
        //如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
        //rabbbit
        //rabbbit
        //rabbbit
        //示例 2：
        //
        //输入：s = "babgbag", t = "bag"
        //输出：5
        //解释：
        //如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
        //babgbag
        //babgbag
        //babgbag
        //babgbag
        //babgbag
        No115 no115 = new No115();

        System.out.println(no115.numDistinct("rabbbit", "rabbit"));
        System.out.println(no115.numDistinct("babgbag", "bag"));
    }
}
