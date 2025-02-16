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
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            c-='a';
            if(cur.children[c]==null) {
                cur.children[c] = new TrieNode();
            }
            cur=cur.children[c];
        }
        cur.isEnd=true;


    }

    public boolean search(String word) {
        int res=find(word);
        if(res==2)return true;
        return false;

    }

    public boolean startsWith(String prefix) {
        int res=find(prefix);
        if(res!=0)return true;
        return false;

    }
    public int find(String prefix) {
        TrieNode cur=root;
        for(char c:prefix.toCharArray()){
            c-='a';
            if(cur.children[c]==null)return 0;
            cur=cur.children[c];
        }
        if(cur.isEnd) {
            return 2;
        } else {
            return 1;
        }

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
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True




    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */