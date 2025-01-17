package src.hot100;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-16 22:48
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class No138 {

    //https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/2361362/138-fu-zhi-dai-sui-ji-zhi-zhen-de-lian-b-6jeo/?envType=study-plan-v2&envId=top-100-liked
    //靠了，题目都没看懂

    public Node copyRandomList(Node head) {
        if(head==null)return null;
        Node cur = head;
        HashMap<Node ,Node> hashMap=new HashMap<>();
        while (cur!=null){
            Node node=new Node(cur.val);
            hashMap.put(cur,node);
            cur=cur.next;
        }
        cur = head;
        while (cur!=null){
            Node node=hashMap.get(cur);
            node.next=hashMap.get(cur.next);
            node.random=hashMap.get(cur.random);
            cur=cur.next;
        }
        return hashMap.get(head);
    }

    public static void main(String[] args) {
        //输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
        //输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
        //示例 2：
        //
        //
        //
        //输入：head = [[1,1],[2,1]]
        //输出：[[1,1],[2,1]]
        //示例 3：
        //
        //
        //
        //输入：head = [[3,null],[3,0],[3,null]]
        //输出：[[3,null],[3,0],[3,null]]
        //
        No138 no138 = new No138();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        Node head = no138.copyRandomList(node1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("=======================================");

        Node newNode=new Node(3);
        Node newNode2=new Node(3);
        Node newNode3=new Node(3);
        newNode.next=newNode2;
        newNode2.next=newNode3;
        newNode2.random=newNode;
        newNode3.random=newNode;
        Node newHead=no138.copyRandomList(newNode);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
        System.out.println("=======================================");






    }
}
