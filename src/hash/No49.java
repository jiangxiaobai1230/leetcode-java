package src.hash;

import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2024-10-19 23:17
 */
public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> hashMap=new HashMap<>();
        List<List<String>> res=new ArrayList<>();
        for(String s:strs){
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String sortedS=String.valueOf(c);
            if(!hashMap.containsKey(sortedS)){
                hashMap.put(sortedS,new ArrayList<>());
            }
            hashMap.get(sortedS).add(s);
        }
        for(Map.Entry<String,List<String>> candidate:hashMap.entrySet()){
            res.add(candidate.getValue());

        }
        return res;

    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        HashMap<String,List<String>> hashMap=new HashMap<>();
//        List<List<String>> res=new ArrayList<>();
//        for(String str:strs){
//            char[] s=str.toCharArray();
//            Arrays.sort(s);
//            String t=String.valueOf(s);
//            if(!hashMap.containsKey(t)){
//                hashMap.put(t,new ArrayList<>());
//            }
//            hashMap.get(t).add(str);
//        }
//        for(Map.Entry<String,List<String>> t:hashMap.entrySet()){
//            res.add(hashMap.get(t.getKey()));
//        }
//        return res;
//
//
//    }
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,List<String>> res=new HashMap<>();
//        for(int i=0;i<strs.length;i++){
//            char[] s=strs[i].toCharArray();
//            Arrays.sort(s);
//            if(res.containsKey(new String(s))){
//                res.get(new String(s)).add(strs[i]);
//
//            }else {
//                List<String> list=new ArrayList<>();
//                list.add(strs[i]);
//                res.put(new String(s),list);
//            }
//
//        }
//        return new ArrayList<>(res.values());
//
//    }

    public static void main(String[] args) {

        //示例 1:
        //
        //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        //示例 2:
        //
        //输入: strs = [""]
        //输出: [[""]]
        //示例 3:
        //
        //输入: strs = ["a"]
        //输出: [["a"]]
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        No49 no49 = new No49();
        no49.groupAnagrams(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

        strs=new String[]{""};
        no49.groupAnagrams(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        strs=new String[]{"a"};
        no49.groupAnagrams(strs);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }

    }
}
