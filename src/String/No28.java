package src.String;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-25 20:24
 */
public class No28 {

    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int[] next=getNext(needle);
        int j=-1;
        for(int i=0;i<haystack.length();i++){
            while(j>=0 &&haystack.charAt(i)!=needle.charAt(j+1)){
                j=next[j];
            }
            if(haystack.charAt(i)==needle.charAt(j+1)){
                j++;
            }
            if(j==needle.length()-1){
                return i-needle.length()+1;
            }
        }
        return -1;


    }
    public int[] getNext(String s){
        int[] next=new int[s.length()];
        int j=-1;
        next[0]=j;
        for(int i=1;i<s.length();i++){
            while(j>=0 && s.charAt(j+1)!=s.charAt(i)){
                j=next[j];

            }
            if(s.charAt(j+1)==s.charAt(i)){
                j++;
            }
            next[i]=j;
        }
        return next;


    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：haystack = "sadbutsad", needle = "sad"
        //输出：0
        //解释："sad" 在下标 0 和 6 处匹配。
        //第一个匹配项的下标是 0 ，所以返回 0 。
        //示例 2：
        //
        //输入：haystack = "leetcode", needle = "leeto"
        //输出：-1
        //解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
        String haystack = "sadbutsad";
        String needle = "sad";
        No28 no28 = new No28();
        System.out.println(no28.strStr(haystack,needle));

        haystack="leetcode";
        needle="leeto";
        System.out.println(no28.strStr(haystack,needle));









    }
}
