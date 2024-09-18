package src;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-14 10:24
 */


public class No206 {
        public ListNode reverseList(ListNode head) {
            ListNode pre,cur,tmp,next;
            pre=null;
            cur=head;

            while(cur!=null){
                tmp=cur.next;
                cur.next=pre;
                pre=cur;
                cur=tmp;

            }
            return pre;


        }

    public static void main(String[] args) {
            //head = [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        No206 no206 = new No206();
        head=no206.reverseList(head);
//        System.out.println(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


    }


}
