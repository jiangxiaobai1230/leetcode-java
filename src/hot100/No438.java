package src.hot100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-07 19:21
 */
public class No438 {

    //https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new LinkedList<>();
        if(s.length()<p.length())return res;
        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();
        Arrays.sort(pp);
        p=String.valueOf(pp);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<p.length()-1;i++){
            sb.append(ss[i]);
        }
        for(int i=p.length()-1;i<s.length();i++){
           sb.append(ss[i]);
           char[] t=String.valueOf(sb).toCharArray();
           Arrays.sort(t);
           String ts=String.valueOf(t);
           if(ts.equals(p)){
               res.add(i-p.length()+1);
           }
           sb.deleteCharAt(0);
        }

        return res;

    }

//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res=new LinkedList<>();
//        int n=s.length(),len=p.length();
//        if(n<len)return res;
//        char[] ch=s.toCharArray();
//        char[] pp=p.toCharArray();
//        Arrays.sort(pp);
//        p= String.valueOf(pp);
//        StringBuffer sb=new StringBuffer();
//        for(int i=0;i<len-1;i++){
//            sb.append(ch[i]);
//        }
//        for(int i=len-1;i<n;i++){
//            sb.append(ch[i]);
//            String sss=sb.toString();
//            char[] cc=sss.toCharArray();
//            Arrays.sort(cc);
//            sss=String.valueOf(cc);
//            if(sss.equals(p)){
//                res.add(i-len+1);
//            }
//            sb.deleteCharAt(0);
//        }
//        return res;
//
//    }


//    //https://leetcode.cn/problems/find-all-anagrams-in-a-string/?envType=study-plan-v2&envId=top-100-liked
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res=new LinkedList<>();
//        int lens=s.length(),lenp=p.length();
//        if(lens<lenp)return res;
//        int l=0,r=0;
//        int[] nums=new int[26];
//        for(int i=0;i<lenp;i++){
//            nums[p.charAt(i)-'a']++;
//        }
//        for(r=0;r<lens;r++){
//            char c=s.charAt(r);
//            nums[c-'a']--;
//            while (nums[c-'a']<0){
//                nums[s.charAt(l)-'a']++;
//                l++;
//            }
//            if(l==r-lenp+1){
//                res.add(l);
//            }
//        }
//
//        return res;
//
//
//    }

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
