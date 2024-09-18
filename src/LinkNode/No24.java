package src.LinkNode;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-15 18:47
 */
public class No24 {
    //这里是没有按照题目要求来的，因为说了不能修改内部的值，重新写一个新的
//    public ListNode swapPairs(ListNode head) {
//        if(head==null||head.next==null){
//            return head;
//        }
//        ListNode pre=head;
//        while (pre!=null&&pre.next!=null){
//            ListNode cur=pre.next;
//            int PreVal = pre.val;
//            int NextVal = cur.val;
//            pre.val=NextVal;
//            cur.val=PreVal;
//            pre=cur.next;
//        }
//        return head;
//
//
//
//
//
//    }


    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=new ListNode();
        ListNode newHead2=new ListNode();
        newHead.next=head;
        newHead2=newHead;
        ListNode pre=newHead.next,next=pre.next;
        while(pre!=null&&pre.next!=null){
            newHead.next=next;
            pre.next=next.next;
            next.next=pre;



            newHead=pre;
            pre=newHead.next;
            if(pre!=null){
                next=pre.next;
            }else{
                return newHead2.next;

            }


        }




        return newHead2.next;

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

//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
////        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
////        node4.next = node5;
        No24 no24 = new No24();
        ListNode head=no24.swapPairs(node1);
        while (head!= null) {
            System.out.println(head.val);
            head = head.next;

        }
    }

}
