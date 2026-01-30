package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-10-09 10:26
 */
public class No92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,head2=dummy,nxt=null;
        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }
        for(int i=0;i<right;i++){
            head2=head2.next;
        }
        nxt=head2.next;
        head2.next=null;
        ListNode reverseprehead=pre.next;
        ListNode reversehead=reverse(pre.next);
        pre.next=reversehead;
        reverseprehead.next=nxt;
        return dummy.next;


    }
    public ListNode reverse(ListNode head) {
        ListNode cur=head,pre=null,nxt=null;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;

        }
        return pre;
    }

    public static void main(String[] args) {

        //输入：head = [1,2,3,4,5], left = 2, right = 4
        //输出：[1,4,3,2,5]
        //示例 2：
        //
        //输入：head = [5], left = 1, right = 1
        //输出：[5]
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        No92 no92 = new No92();
        System.out.println(no92.reverseBetween(node1, 2, 4));
        ListNode node6 = new ListNode(5);
        System.out.println(no92.reverseBetween(node6, 1, 1));



    }
}
