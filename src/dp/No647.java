package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-25 19:54
 */
public class No647 {


    public int countSubstrings(String s) {
        int len=s.length();
        int res=0;
        boolean[][] dp=new boolean[len][len];
        for(int j=0;j<len;j++){
            for(int i=0;i<=j;i++){
                if(s.charAt(i)==s.charAt(j)) {
                    if (j - i <= 1 || (dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        res++;
                    }
                }

            }

        }
        return res;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "abc"
        //输出：3
        //解释：三个回文子串: "a", "b", "c"
        //示例 2：
        //
        //输入：s = "aaa"
        //输出：6
        //解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
        No647 no647 = new No647();
        System.out.println(no647.countSubstrings("abc"));
        System.out.println(no647.countSubstrings("aaa"));


    }
}
