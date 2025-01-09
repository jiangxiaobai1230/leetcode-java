package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-08 20:41
 */
public class No76 {

    //https://leetcode.cn/problems/minimum-window-substring/solutions/2713911/liang-chong-fang-fa-cong-o52mn-dao-omnfu-3ezz/?envType=study-plan-v2&envId=top-100-liked
    public String minWindow(String s, String t) {
        int lens=s.length(),lent=t.length();
        if(lens<lent)return "";
        int[] cntS=new int[128];
        int[] cntT=new int[128];
        for(int i=0;i<lent;i++){
            cntT[t.charAt(i)]++;
        }
        int ansLeft=-1,ansRight=lens-1;
        int right,left=0;
        for(right=0;right<lens;right++){
            cntS[s.charAt(right)]++;
            while (isCovered(cntS,cntT)){
                if(ansRight-ansLeft>right-left){
                    ansLeft=left;
                    ansRight=right;
                }
                cntS[s.charAt(left)]--;
                left++;
            }

        }
        if(ansLeft<0)return "";
        return s.substring(ansLeft,ansRight+1);

    }
    Boolean isCovered(int[] cntS,int[] cntT){
        for(int i='A';i<='Z';i++){
            if(cntS[i]<cntT[i])return false;
        }
        for(int i='a';i<='z';i++){
            if(cntS[i]<cntT[i])return false;
        }
        return true;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：s = "ADOBECODEBANC", t = "ABC"
        //输出："BANC"
        //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
        //示例 2：
        //
        //输入：s = "a", t = "a"
        //输出："a"
        //解释：整个字符串 s 是最小覆盖子串。
        //示例 3:
        //
        //输入: s = "a", t = "aa"
        //输出: ""
        //解释: t 中两个字符 'a' 均应包含在 s 的子串中，
        //因此没有符合条件的子字符串，返回空字符串。
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new No76().minWindow(s, t));
        s = "a";
        t = "a";
        System.out.println(new No76().minWindow(s, t));



    }
}
