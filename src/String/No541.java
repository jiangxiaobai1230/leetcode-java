package src.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-22 19:51
 */
public class No541 {


    public String reverseStr(String s, int k) {
        char[] l=s.toCharArray();
        StringBuffer sb=new StringBuffer();
        int len=s.length();
        if(len<k){
            reverse(l,0,len-1);
            return String.valueOf(l);
        }
        for(int i=0;i<len;i+=2*k){
            int r=i+k-1;
            reverse(l,i,Math.min(r,len-1));

        }
        return String.valueOf(l);
    }
    public void reverse(char[] c,int l,int r){
        while(l<r){
            char t=c[l];
            c[l]=c[r];
            c[r]=t;
            l++;
            r--;
        }

    }

    public static void main(String[] args) {

        //示例 1：
        //
        //输入：s = "abcdefg", k = 2
        //输出："bacdfeg"
        //示例 2：
        //
        //输入：s = "abcd", k = 2
        //输出："bacd"
        String s = "abcdefgh";
        int k = 3;
        No541 no541 = new No541();
        String t=no541.reverseStr(s, k);
        System.out.println(t);


        s="ab";
        k=3;
        t=no541.reverseStr(s, k);
        System.out.println(t);

    }
}
