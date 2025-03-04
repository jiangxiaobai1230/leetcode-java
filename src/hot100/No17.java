package src.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-26 23:46
 */
public class No17 {
    private String[] characters=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuvw","xyz"};
    private List<String >ans=new ArrayList<>();
    private char[] digits;
    private char[] path;
    public List<String> letterCombinations(String digits) {
        int n=digits.length();
        if(n==0)return ans;
        this.digits=digits.toCharArray();
        path = new char[n]; // 注意 path 长度一开始就是 n，不是空数组
        dfs(0);
        return ans;
    }
    public void dfs(int index){
        if(path.length==index){
            ans.add(new String(path));
            return;
        }
        int num =digits[index]-'0';
        String s=characters[num];
        for(int i=0;i<s.length();i++){
            path[index]=s.charAt(i);
            dfs(index+1);
        }

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：digits = "23"
        //输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        //示例 2：
        //
        //输入：digits = ""
        //输出：[]
        //示例 3：
        //
        //输入：digits = "2"
        //输出：["a","b","c"]

        String digits="8";
        No17 no17=new No17();
        List<String> strings=no17.letterCombinations(digits);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        String digits2="";
        no17=new No17();
        List<String> strings2=no17.letterCombinations(digits2);
        for (String string : strings2) {
            System.out.println(string);
        }
        System.out.println();
        String digits3="2";
        no17=new No17();
        List<String> strings3=no17.letterCombinations(digits3);
        for (String string : strings3) {
            System.out.println(string);
        }
        System.out.println();



    }
}
