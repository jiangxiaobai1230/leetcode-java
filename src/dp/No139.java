package src.dp;

import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-30 23:35
 */
public class No139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int len=wordDict.size();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<len;j++){
                String word=wordDict.get(j);
                if(i>=word.length()&&dp[i-word.length()]&&s.substring(i-word.length(),i).equals(word)){
                    dp[i]=true;
                    break;
                }


            }
        }
        return dp[s.length()];

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入: s = "leetcode", wordDict = ["leet", "code"]
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
        No139 no139 = new No139();
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        boolean result = no139.wordBreak(s, wordDict);
        System.out.println(result);

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");
        result = no139.wordBreak(s, wordDict);
        System.out.println(result);

        s = "applepenapple";
        wordDict = List.of("apple", "pen");
        result = no139.wordBreak(s, wordDict);
        System.out.println(result);





    }
}
