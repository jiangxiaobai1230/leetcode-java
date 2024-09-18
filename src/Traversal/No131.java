package src.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-26 19:10
 */
public class No131 {
    private List<List<String>>  res=new ArrayList<>();
    private List<String> path=new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.length()==1) {
            path.add(s);
            res.add(path);
            return res;
        }
        backTracking(s,0);
        return res;

    }
    public void backTracking(String s,int index){

        if(index>=s.length()){
            res.add(new ArrayList<>(path));
            return;

        }
        for(int i=index;i<s.length();i++){
            if(isHuiWen(s.substring(index,i+1))){
                path.add(s.substring(index,i+1));
                backTracking(s,i+1);
                path.remove(path.size()-1);
            }

        }

    }
    public boolean isHuiWen(String s){
        if("".equals(s))return false;
        boolean flag=true;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                flag=false;
                break;
            }

        }
        return flag;
    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：s = "aab"
        //输出：[["a","a","b"],["aa","b"]]
        //示例 2：
        //
        //输入：s = "a"
        //输出：[["a"]]
        //

        String s = "aab";
        No131 no131 = new No131();
        List<List<String>> partition = no131.partition(s);
        for (List<String> list : partition) {
            for (String s1 : list) {
                System.out.print(s1 + " ");
            }
            System.out.println();
        }
        System.out.println();
        String s1 = "a";
        no131 = new No131();
        List<List<String>> partition1 = no131.partition(s1);
        for (List<String> list : partition1) {
            for (String s2 : list) {
                System.out.print(s2 + " ");
            }
            System.out.println();
        }
        System.out.println();



    }
}
