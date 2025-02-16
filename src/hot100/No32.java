package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 17:16
 */
public class No32 {
    //https://leetcode.cn/problems/longest-valid-parentheses/solutions/314827/shou-hua-tu-jie-zhan-de-xiang-xi-si-lu-by-hyj8/?envType=study-plan-v2&envId=top-100-liked

    //dp[i]是以s[i]结尾的最大字串长度
    public int longestValidParentheses(String s) {
        if(s.length()==0||s.length()==1)return 0;
        int res=0;
        int[] dp=new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='('){
                dp[i]=0;
            }else {
                if(s.charAt(i-1)=='('){
                    if(i>=2)dp[i]=dp[i-2]+2;
                    else dp[i]=2;
                }else {
                    if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        if(i-dp[i-1]-2>=0){
                            dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2;
                        }else dp[i]=dp[i-1]+2;

                    }else dp[i]=0;
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "(()"
        //输出：2
        //解释：最长有效括号子串是 "()"
        //示例 2：
        //
        //输入：s = ")()())"
        //输出：4
        //解释：最长有效括号子串是 "()()"
        //示例 3：
        //
        //输入：s = ""
        //输出：0
        No32 no32 = new No32();
        System.out.println(no32.longestValidParentheses("())"));
        System.out.println(no32.longestValidParentheses(")()())"));
        System.out.println(no32.longestValidParentheses(""));

    }
}
