package src.hot100;

import java.nio.channels.WritableByteChannel;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-19 16:28
 */
public class No3 {

    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        if(n<2)return n;
        int res=0;
        int left=0,right=0;
        int[] count=new int[128];
        while (right<n){
            count[s.charAt(right)]++;
            while (count[s.charAt(right)]>1){
                count[s.charAt(left)]--;
                left++;
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int n=s.length();
//        if(n<2)return n;
//        int res=0;
//        int left=0,right=0;
//        int[] count=new int[128];
//        while (right<n){
//            if(count[s.charAt(right)]!=0){
//                while (left<=right&&s.charAt(left)!=s.charAt(right)){
//                    count[s.charAt(left)]--;
//                    left++;
//                }
//                while (left<right&&s.charAt(left)==s.charAt(right)) {
//                    count[s.charAt(left)]--;
//                    left++;
//                    res=Math.max(res,right-left+1);
//                }
//            }
//            count[s.charAt(right)]++;
//            res=Math.max(res,right-left+1);
//            right++;
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: s = "abcabcbb"
        //输出: 3
        //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        //示例 2:
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
        No3 no3 = new No3();
        System.out.println(no3.lengthOfLongestSubstring("aa"));
        System.out.println(no3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(no3.lengthOfLongestSubstring("pwwkew"));
    }
}
