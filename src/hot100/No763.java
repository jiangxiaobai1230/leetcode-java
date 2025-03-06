package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-06 00:18
 */
public class No763 {
//        链接：https://leetcode.cn/problems/partition-labels/solutions/2806706/ben-zhi-shi-he-bing-qu-jian-jian-ji-xie-ygsn8/
    public List<Integer> partitionLabels(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[c[i] - 'a'] = i; // 每个字母最后出现的下标
        }
        List<Integer> res=new ArrayList<>();
        int start=0,end=0;
        for(int i=0;i<n;i++){
            end=Math.max(end,last[c[i]-'a']);
            if(i==end){
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //示例 1：
        //输入：s = "ababcbacadefegdehijhklij"
        //输出：[9,7,8]
        //解释：
        //划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
        //每个字母最多出现在一个片段中。
        //像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
        //示例 2：
        //
        //输入：s = "eccbbbbdec"
        //输出：[10]
        String s = "ababcbacadefegdehijhklij";
        No763 no763 = new No763();
        System.out.println(no763.partitionLabels(s));
        s = "eccbbbbdec";
        System.out.println(no763.partitionLabels(s));

    }
}
