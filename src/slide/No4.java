package src.slide;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-06 22:49
 */
public class No4 {

    //暴力有一个例子超时
//    public int lengthOfLongestSubstring(String s) {
//        int res=1,len=s.length();
//        if(len==0||len==1)return len;
//        int[][] dp=new int[len+1][len+1];
//        for(int i=1;i<=len;i++){
//            for(int j=1;j<=len;j++){
//                dp[i][j]=1;
//            }
//        }
//
//        for(int i=1;i<=len;i++){
//            for(int j=i+1;j<=len;j++){
//                char c=s.charAt(j-1);
//                String t=s.substring(i-1,j-1);
//                if(t.contains(String.valueOf(c))){
//                    dp[i][j]=0;
//                    break;
//                }else dp[i][j]=dp[i][j-1]+1;
//                res=Math.max(dp[i][j],res);
//            }
//        }
//        return res;
//    }

    public int lengthOfLongestSubstring(String s) {
        int res=0,left=-1,len=s.length();
        Map<Character, Integer> map = new HashMap<>();
        if(len==0||len==1)return len;
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(map.containsKey(c)&&map.get(c)<i){
                left=Math.max(left,map.get(c));
            }else {

            }
            map.put(c,i);
            res=Math.max(res,i-left);

        }
        return res;
    }


    public static void main(String[] args) {
        //示例 1:
        //
        //输入: s = "abcabcbb"
        //输出: 3
        //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        //示例 2: -
        //
        //输入: s = "bbbbb"
        //输出: 1
        //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        //示例 3:
        //
        //输入: s = "pwwkew"
        //输出: 3
        //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
        String s = "abcabcbb";
        No4 no4 = new No4();
        System.out.println(no4.lengthOfLongestSubstring(s));
        System.out.println(no4.lengthOfLongestSubstring("bbbbb"));
        System.out.println(no4.lengthOfLongestSubstring("pwwkew"));




    }
}
