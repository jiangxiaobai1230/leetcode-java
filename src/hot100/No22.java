package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-27 17:43
 */
public class No22 {
    private int n;
    private final List<String> res = new ArrayList<>();
    private char[] path;


    public List<String> generateParenthesis(int n) {
        this.n=n;
        path=new char[2*n];
        dfs(0,0);
        return res;

    }
    private void dfs(int i,int open){
        if(i==2*n){
            res.add(new String(path));
            return;
        }
        if(open<n) {
            path[i]='(';
            dfs(i+1,open+1);
        }
        if(i-open<open){
            path[i]=')';
            dfs(i+1,open);
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
        System.out.println(no22.generateParenthesis(3));
        no22 = new No22();
        System.out.println(no22.generateParenthesis(1));

    }
}
