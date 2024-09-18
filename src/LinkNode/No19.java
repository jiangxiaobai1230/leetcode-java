package src.LinkNode;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-15 20:01
 */
public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast,low,dummy = new ListNode(0);
        dummy.next=head;
        fast=dummy;
        low=dummy;
        for(int i=0;i<n+1;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            low=low.next;
        }
        ListNode deleteNode=low.next;
        ListNode tmpNode=deleteNode.next;
        low.next=tmpNode;

        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        No19 no19 = new No19();
        ListNode head=no19.removeNthFromEnd(node1,2);
        while (head!= null) {
            System.out.println(head.val);
            head = head.next;

        }

    }
}
