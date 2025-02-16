package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 22:42
 */
public class No5 {
    //https://leetcode.cn/problems/longest-palindromic-substring/solutions/2939834/san-chong-fang-fa-dp-zhong-xin-kuo-zhan-pcas3/?envType=study-plan-v2&envId=top-100-liked

    public String longestPalindrome(String s) {
        if(s.length()==1)return s;
        int n=s.length();
        int l=0,r=0;
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            if(i<n-1&&s.charAt(i)==s.charAt(i+1)) {
                dp[i][i + 1] = true;
                l=i;
                r=i+1;
            }
        }
        for(int i=n-3;i>=0;i--){
            for(int j=i+2;j<n;j++){
                if(dp[i+1][j-1]&&s.charAt(i)==s.charAt(j)) {
                    dp[i][j] = true;
                    if(j-i>r-l){
                        l=i;
                        r=j;
                    }
                }

            }
        }
        return s.substring(l,r+1);
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "babad"
        //输出："bab"
        //解释："aba" 同样是符合题意的答案。
        //示例 2：
        //
        //输入：s = "cbbd"
        //输出："bb"
        No5 no5 = new No5();
        System.out.println(no5.longestPalindrome("ac"));
        System.out.println(no5.longestPalindrome("cbbd"));

    }
}
