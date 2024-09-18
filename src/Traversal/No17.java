package src.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-25 10:04
 */
public class No17 {
    private String[] letterMap = {
            "",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };
    private List<String> res=new ArrayList<>();
    private StringBuffer sb=new StringBuffer();
    public List<String> letterCombinations(String digits) {
        if(Objects.equals(digits, ""))return res;
        backtracking(digits,0);
        return res;

    }
    public void backtracking(String digits,int index){
        if(sb.length()==digits.length()){
            res.add(String.valueOf(sb));
            return;

        }
        int c=digits.charAt(index)-'0';
        String s=letterMap[c];
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            backtracking(digits,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {

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

        String digits = "23";
        No17 no17 = new No17();
        List<String> strings = no17.letterCombinations(digits);
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();

        String digits2 = "";
        no17 = new No17();
        List<String> strings2 = no17.letterCombinations(digits2);
        for (String string : strings2) {
            System.out.println(string);
        }
        System.out.println();

        String digits3 = "2";
        no17 = new No17();
        List<String> strings3 = no17.letterCombinations(digits3);
        for (String string : strings3) {
            System.out.println(string);
        }
        System.out.println();


    }
}
