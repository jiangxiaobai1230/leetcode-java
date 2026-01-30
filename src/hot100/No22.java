package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-12-13 23:12
 */
public class No22 {
    List<String> res=new ArrayList<>();
    char[] path;
    int n;



    public List<String> generateParenthesis(int n) {
        this.n=n;
        path=new char[2*n];
        dfs(0,0);
        return res;
    }
    public void dfs(int i,int left){
        if(i==2*n){
            res.add(new String(path));
            return;
        }
        if(left<n){
            path[i]='(';
            dfs(i+1,left+1);
        }
        if(left>i-left){
            path[i]=')';
            dfs(i+1,left);
        }

    }
    public static void main(String[] args) {
        //示例 1：
        //
        //输入：n = 3
        //输出：["((()))","(()())","(())()","()(())","()()()"]
        //示例 2：
        //
        //输入：n = 1
        //输出：["()"]
        No22 no22 = new No22();
        List<String> strings = no22.generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        strings = no22.generateParenthesis(1);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();

    }
}
