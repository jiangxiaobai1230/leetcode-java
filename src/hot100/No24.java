package src.hot100;

import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 22:46
 */
public class No24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        if(head==null||head.next==null)return head;
        ListNode cur,pre,nxt;
        cur=head;
        pre=dummy;
        while (pre!=null&&pre.next!=null&&pre.next.next!=null){
            cur=pre.next;
            pre.next=cur.next;
            nxt=pre.next.next;
            pre.next.next=cur;
            cur.next=nxt;
            pre=cur;
            cur=nxt;
        }
//        pre.next=cur;
        return dummy.next;

    }

    public static void main(String[] args) {
        //输入：head = [1,2,3,4]
        //输出：[2,1,4,3]
        //示例 2：
        //
        //输入：head = []
        //输出：[]
        //示例 3：
        //
        //输入：head = [1]
        //输出：[1]

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head2 = new ListNode();
        ListNode head3 = new ListNode(1);
        No24 no24 = new No24();
        ListNode res1 = no24.swapPairs(head1);
        ListNode res2 = no24.swapPairs(head2);
        ListNode res3 = no24.swapPairs(head3);
        while (res1 != null) {
            System.out.println(res1.val);
            res1 = res1.next;
        }
        System.out.println("-----");
        while (res2 != null) {
            System.out.println(res2.val);
            res2 = res2.next;
        }
        System.out.println("-----");
        while (res3 != null) {
            System.out.println(res3.val);
            res3 = res3.next;
        }


    }
}
