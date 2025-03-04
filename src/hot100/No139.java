package src.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-03 14:57
 */
public class No139 {
    private HashSet<String> hashSet=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0;i<wordDict.size();i++){
            hashSet.add(wordDict.get(i));
        }
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int j=1;j<=s.length();j++){
            for(int i=0;i<j;i++){
                if(dp[i]==true&&hashSet.contains(s.substring(i,j))){
                    dp[j]=true;
                }
            }
        }
        return dp[s.length()];

    }

//    private HashSet<String> hashSet=new HashSet<>();
//    int maxLen=0;
//    private String path=new String();
//    private boolean flag=false;
//    public boolean wordBreak(String s, List<String> wordDict) {
//        for(int i=0;i<wordDict.size();i++){
//            hashSet.add(wordDict.get(i));
//            if(maxLen<wordDict.get(i).length()){
//                maxLen=wordDict.get(i).length();
//            }
//        }
//        dfs(s,0);
//        return flag;
//
//
//    }
//    private void dfs(String s,int index) {
//        if (flag) return;
//        if (index == s.length() && path.equals(s)) {
//            flag = true;
//            return;
//        }
//        for (int i = index; i < s.length(); i++) {
//            String t = new String(path);
//            for (int j = i; j < s.length() && j < i + maxLen; j++) {
//                String ss = s.substring(i, j + 1);
//                if (hashSet.contains(ss)) {
//                    path += ss;
//                    dfs(s, j + 1);
//                    path = t;
//                } else continue;
//            }
//        }
//    }
//        for (int i = index; i < s.length(); i++) {
//            if (hashSet.contains(s.substring(index, i + 1))) {
//                dfs(s, i + 1);
//            }
//        }




    public static void main(String[] args) {
        //示例 1：
        //
        //输入: s = "aaaaaaa", wordDict = ["aaaa", "aa"]
        //输出: true
        //解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
        //示例 2：
        //
        //输入: s = "applepenapple", wordDict = ["apple", "pen"]
        //输出: true
        //解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
        //     注意，你可以重复使用字典中的单词。
        //示例 3：
        //
        //输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
        //输出: false
        System.out.println(new No139().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aa")));
        System.out.println(new No139().wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(new No139().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));

    }
}
