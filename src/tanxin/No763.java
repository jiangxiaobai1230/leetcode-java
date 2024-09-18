package src.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-27 22:15
 */
public class No763 {

    public List<Integer> partitionLabels(String s) {
        int[] lastIndexList=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int charNum=c-'a';
            lastIndexList[charNum]=i;
        }
        int len=0;
        List<Integer> res=new ArrayList<>();
        int index=-1;
        for(int i=0;i<s.length();i++){
            index=Math.max(index,lastIndexList[s.charAt(i)-'a']);
            if(index==i){
                index=i+1;
                res.add(i-len+1);
                len=i+1;
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
        No763 no763 = new No763();
        List<Integer> list = no763.partitionLabels("ababcbacadefegdehijhklij");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println();
        List<Integer> list1 = no763.partitionLabels("eccbbbbdec");
        for (Integer integer : list1) {
            System.out.println(integer);
        }


    }
}
