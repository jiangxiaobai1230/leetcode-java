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
        int left=0,right=lens-1,resleft=0,resright=lens-1;
        int[] cnts=new int[128];
        int[] cntt=new int[128];
        for(int i=0;i<lent;i++){
            cntt[t.charAt(i)]++;
        }
        boolean flag=false;
        for(int i=0;i<lens;i++){
            cnts[s.charAt(i)]++;
            while (isCover(cnts,cntt)){
                flag=true;
                right=i;
                if(resright-resleft>right-left){
                    resleft=left;
                    resright=right;
                }
                cnts[s.charAt(left++)]--;
            }

        }
        if(!flag)return "";
        return s.substring(resleft,resright+1);

    }
    public boolean isCover(int[] cnts,int[] cntt){
        for(int i=0;i<cntt.length;i++){
            if(cnts[i]<cntt[i])return false;
        }
        return true;
    }


//    public String minWindow(String s, String t) {
//        int lens=s.length(),lent=t.length();
//        if(lens<lent)return "";
//
//        int[] cntS=new int[128],cntT=new int[128];
//        for(int i=0;i<lent;i++){
//            cntT[t.charAt(i)]++;
//        }
//        int left=0,right=lens-1;
//        int ansleft=0,ansright=lens-1;
//        for(int i=0;i<lens;i++){
//            cntS[s.charAt(i)]++;
//            while (isCover(cntS,cntT)){
//                right=i;
//                cntS[s.charAt(left++)]--;
//            }
//            if(left>right)return s.substring(right,left);
//            if(ansright-ansleft>right-left){
//                ansright=right;
//                ansleft=left;
//            }
//
//        }
//        if(ansleft==0&&ansright==lens-1)return "";
//        return s.substring(ansleft-1,ansright+1);
//
//    }
//    public boolean isCover(int[] cntS,int[] cntT){
//        for(int i=0;i<cntS.length;i++){
//            if(cntS[i]<cntT[i])return false;
//        }
//        return true;
//    }

//    public String minWindow(String s, String t) {
//        int lens=s.length(),lent=t.length();
//        if(lens<lent)return "";
//        int[] cntS=new int[128];
//        int[] cntT=new int[128];
//        for(int i=0;i<lent;i++){
//            cntT[t.charAt(i)]++;
//        }
//        int ansLeft=-1,ansRight=lens-1;
//        int right,left=0;
//        for(right=0;right<lens;right++){
//            cntS[s.charAt(right)]++;
//            while (isCovered(cntS,cntT)){
//                if(ansRight-ansLeft>right-left){
//                    ansLeft=left;
//                    ansRight=right;
//                }
//                cntS[s.charAt(left)]--;
//                left++;
//            }
//
//        }
//        if(ansLeft<0)return "";
//        return s.substring(ansLeft,ansRight+1);
//
//    }
//    Boolean isCovered(int[] cntS,int[] cntT){
//        for(int i='A';i<='Z';i++){
//            if(cntS[i]<cntT[i])return false;
//        }
//        for(int i='a';i<='z';i++){
//            if(cntS[i]<cntT[i])return false;
//        }
//        return true;
//
//    }

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
        t = "b";
        System.out.println(new No76().minWindow(s, t));



    }
}
