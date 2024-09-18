package src.hash;

import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-18 21:32
 */
public class No242 {
    public boolean isAnagram(String s, String t) {


        int lenS=s.length();
        int lenT=t.length();
        if(lenS!=lenT){
            return false;
        }
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<lenS;i++){
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
            hm.put(t.charAt(i),hm.getOrDefault(t.charAt(i),0)-1);
        }
        for (int val : hm.values()) {
            if(val!=0){
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: s = "anagram", t = "nagaram"
        //输出: true
        //示例 2:
        //
        //输入: s = "rat", t = "car"
        //输出: false
        No242 no242 = new No242();
        System.out.println(no242.isAnagram("anagram", "nagaram"));
        System.out.println(no242.isAnagram("rat", "car"));

    }
}
