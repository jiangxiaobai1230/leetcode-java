package src.hot100;

import java.util.HashMap;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-18 22:50
 */

class LRUCache {

    //https://leetcode.cn/problems/lru-cache/solutions/2456294/tu-jie-yi-zhang-tu-miao-dong-lrupythonja-czgt/?envType=study-plan-v2&envId=top-100-liked

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }


    }
    private final int capacity;
    private Node dummy=new Node(0,0);
    HashMap<Integer,Node> hashMap=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        dummy.pre=dummy;
        dummy.next=dummy;
    }

    public int get(int key) {
        Node node=getNode(key);
        return node==null?-1:node.value;

    }
    public Node getNode(int key){
        if(!hashMap.containsKey(key)){
            return null;
        }
        Node node=hashMap.get(key);
        remove(node);
        push(node);
        return node;

    }
    public void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;

    }
    public void push(Node node){
        node.pre=dummy;
        node.next=dummy.next;
        node.next.pre=node;
        node.pre.next=node;

    }

    public void put(int key, int value) {
        if(get(key)==-1){
            Node node=new Node(key,value);
            hashMap.put(key,node);
            push(node);
        }else {
            Node node=hashMap.get(key);
            node.value=value;
            remove(node);
            push(node);
        }
        if(hashMap.size()>capacity){
            Node lastNode=dummy.pre;
            hashMap.remove(lastNode.key);
            remove(lastNode);
        }

    }
}
public class No146 {
    public static void main(String[] args) {
        //示例：
        //
        //输入
        //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        //输出
        //[null, null, null, 1, null, -1, null, -1, 3, 4]
        //
        //解释
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4


    }
}
