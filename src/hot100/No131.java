package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 16:12
 */
public class No131 {
    private final List<List<String>> res = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    private String s;


    public List<List<String>> partition(String s) {
        this.s=s;
        dfs(0);
        return res;

    }
    public void dfs(int i){
        if(i==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isHuiWen(i,j)){
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.remove(path.size() - 1); // 恢复现场

            }
        }

    }
    public boolean isHuiWen(int left,int right){
        while (left<right){
            if(s.charAt(left)!=s.charAt(right))return false;
            else {
                left++;
                right--;
            }
        }
        return true;
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
        No131 no131=new No131();
        List<List<String>>  aab = no131.partition("aab");
        for(List<String> list:aab){
            for(String str:list){
                System.out.print(str+" ");
            }
        }
        System.out.println();
        List<List<String>>  a = no131.partition("a");
        for(List<String> list:a){
            for(String str:list){
                System.out.print(str+" ");
            }
        }


    }
}
