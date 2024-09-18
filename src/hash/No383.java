package src.hash;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-21 09:09
 */
public class No383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineList=new int[26];
        int[] ransomNoteList=new int[26];

        for(int i=0;i<magazine.length();i++){
            int ch=magazine.charAt(i)-'a';
            magazineList[ch]+=1;
        }
        for(int i=0;i<ransomNote.length();i++){
            int ch=ransomNote.charAt(i)-'a';
            if(magazineList[ch]==0){
                return false;
            }else{
                magazineList[ch]-=1;

            }
        }
        return true;



    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：ransomNote = "a", magazine = "b"
        //输出：false
        //示例 2：
        //
        //输入：ransomNote = "aa", magazine = "ab"
        //输出：false
        //示例 3：
        //
        //输入：ransomNote = "aa", magazine = "aab"
        //输出：true


        No383 no383 = new No383();
        System.out.println(no383.canConstruct("a", "b"));
        System.out.println(no383.canConstruct("aa", "ab"));
        System.out.println(no383.canConstruct("aa", "aab"));
        System.out.println(no383.canConstruct("aaa", "aab"));


    }
}
