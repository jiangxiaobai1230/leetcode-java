package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-12 22:07
 */

//https://blog.csdn.net/m0_46202073/article/details/107253959
    //https://leetcode.cn/problems/implement-trie-prefix-tree/solutions/2993894/cong-er-cha-shu-dao-er-shi-liu-cha-shu-p-xsj4/?envType=study-plan-v2&envId=top-100-liked

class TrieNode{

    boolean isEnd;
    TrieNode[] children=new TrieNode[26];

}
public class Trie {
    private TrieNode root;

    public Trie() {
        root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode head=root;
        for(int i=0;i<word.length();i++){
            if(head.children[word.charAt(i)-'a']==null) {
                head.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            head=head.children[word.charAt(i)-'a'];
        }
        head.isEnd=true;

    }

    public boolean search(String word) {
        if(find(word)==2)return true;
        return false;

    }

    public boolean startsWith(String prefix) {
        if(find(prefix)!=-1)return true;
        else return false;


    }
    private int find(String word){
        TrieNode head=root;
        for(int i=0;i<word.length();i++){
            if(head.children[word.charAt(i)-'a']==null)return -1;
            head=head.children[word.charAt(i)-'a'];
        }
        if(head.isEnd)return 2;
        return 1;

    }


    public static void main(String[] args) {
        //示例：
        //
        //输入
        //["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        //输出
        //[null, null, true, false, true, null, true]
        //
        //解释
        //Trie trie = new Trie();
        //trie.insert("apple");
        //trie.search("apple");   // 返回 True
        //trie.search("app");     // 返回 False
        //trie.startsWith("app"); // 返回 True
        //trie.insert("app");
        //trie.search("app");     // 返回 True
        //
//        Trie trie = new Trie();
//        trie.insert("apple");
//        trie.search("apple");   // 返回 True
//        trie.search("app");     // 返回 False
//        trie.startsWith("app"); // 返回 True
//        trie.insert("app");
//        trie.search("app");     // 返回 True

        //["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
        //[[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]

        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");
        System.out.println(trie.search("apps"));
        System.out.println(trie.search("app"));
        System.out.println(trie.search("ad"));
        System.out.println(trie.search("applepie"));

        System.out.println(trie.search("rest"));
        System.out.println(trie.search("jan"));
        System.out.println(trie.search("rent"));
        System.out.println(trie.search("beer"));
        System.out.println(trie.search("jam"));
        System.out.println(trie.startsWith("apps"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("ad"));
        System.out.println(trie.startsWith("applepie"));
        System.out.println(trie.startsWith("rest"));
        System.out.println(trie.startsWith("jan"));
        System.out.println(trie.startsWith("rent"));
        System.out.println(trie.startsWith("beer"));
        System.out.println(trie.startsWith("jam"));




    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */