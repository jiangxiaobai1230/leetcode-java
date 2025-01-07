package src.slide;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-07 19:21
 */
public class No438 {


    //https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new LinkedList<>();
        int lens=s.length(),lenp=p.length();
        if(lens<lenp)return res;
        int l=0,r=0;
        int[] nums=new int[26];
        for(int i=0;i<lenp;i++){
            nums[p.charAt(i)-'a']++;
        }
        for(r=0;r<lens;r++){
            char c=s.charAt(r);
            nums[c-'a']--;
            while (nums[c-'a']<0){
                nums[s.charAt(l)-'a']++;
                l++;
            }
            if(l==r-lenp+1){
                res.add(l);
            }
        }

        return res;


    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: s = "cbaebabacd", p = "abc"
        //输出: [0,6]
        //解释:
        //起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        //起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
        // 示例 2:
        //
        //输入: s = "abab", p = "ab"
        //输出: [0,1,2]
        //解释:
        //起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
        //起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
        //起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
        String s = "cbaebabacd";
        String p = "abc";
        No438 no438 = new No438();
        List<Integer> list = no438.findAnagrams(s, p);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println();
        List<Integer> list1 = no438.findAnagrams("abab", "ab");
        for (Integer integer : list1) {
            System.out.println(integer);
        }
        System.out.println();

    }

}
