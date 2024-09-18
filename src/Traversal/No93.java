package src.Traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-28 20:56
 */
public class No93 {
    private List<String> res=new ArrayList<>();
    private List<String> tmp=new ArrayList<>();
    private StringBuffer num=new StringBuffer();
    public List<String> restoreIpAddresses(String s) {
        if(s.length()<4||s.length()>12)return res;
        backtracking(s,0,0);
        return res;

    }
    public void backtracking(String s,int index,int count){
        if(tmp.size()==4&&count==4){
            if(!res.contains(String.join(".",tmp))){
                res.add(String.join(".",tmp));
            }
            return;
        }
        if(tmp.size()>4)return;
        for(int i=index;i<s.length();i++){
            String ss;
            if(count==3){
                ss=s.substring(index,s.length());
            }
            else {
                ss=s.substring(index,i+1);
            }
            if(isLegal(ss)){
                tmp.add(ss);
                count++;
                backtracking(s,i+1,count);
                tmp.remove(tmp.size()-1);
                count--;
            }

        }



    }

    public boolean isLegal(String s){

        if(s.isEmpty())return false;
        if(s.charAt(0)=='0' && s.length()>1){
            return false;
        }
        if(s.length()>3)return false;
        if(s.length()<3)return true;
        if(s.compareTo("255")>0)return false;

        return true;


    }

//    if(isLegal(s.substring(index,s.length()))){
//        tmp.add(s.substring(index,s.length()));
//        num=new StringBuffer();
//        num.append(tmp.get(0));
//        num.append(".");
//        num.append(tmp.get(1));
//        num.append(".");
//        num.append(tmp.get(2));
//        num.append(".");
//        num.append(tmp.get(3));
//        res.add(String.valueOf(num));
//        return;
//
//    }
//    public boolean isLegal(String s){
//        String[] strings=s.split(".");
//        for(int i=0;i<strings.length;i++){
//            String tmp=strings[i];
//            if(tmp.charAt(0)=='0' && tmp.length()>1){
//                return false;
//            }
//            if(tmp.compareTo("256")>0)return false;
//            if(tmp.compareTo("0")<0)return false;
//        }
//        return true;
//
//
//    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：s = "25525511135"
        //输出：["255.255.11.135","255.255.111.35"]
        //示例 2：
        //
        //输入：s = "0000"
        //输出：["0.0.0.0"]
        //示例 3：
        //
        //输入：s = "101023"
        //输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        //

        No93 no93 = new No93();
        List<String> strings = no93.restoreIpAddresses("000256");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        no93 = new No93();
        strings=no93.restoreIpAddresses("0000");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        no93 = new No93();
        strings=no93.restoreIpAddresses("101023");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();


    }
}
