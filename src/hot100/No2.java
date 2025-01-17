package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-13 22:49
 */
public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null)return null;
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode node=new ListNode(0),cur=node;
        int carry=0;
        while (l1!=null||l2!=null||carry!=0){
            if(l1!=null){
                carry=carry+ l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry=carry+ l2.val;
                l2=l2.next;
            }
            ListNode num=new ListNode(carry%10);
            cur.next=num;
            cur=cur.next;
            carry=carry/10;


        }
        return node.next;
    }

    public static void main(String[] args) {
        //输入：l1 = [2,4,3], l2 = [5,6,4]
        //输出：[7,0,8]
        //解释：342 + 465 = 807.
        //示例 2：
        //
        //输入：l1 = [0], l2 = [0]
        //输出：[0]
        //示例 3：
        //
        //输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        //输出：[8,9,9,9,0,0,0,1]
        No2 no2 = new No2();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = no2.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("==========================");
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        listNode = no2.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("==========================");
        l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);
        l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        listNode = no2.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("==========================");

    }
}
