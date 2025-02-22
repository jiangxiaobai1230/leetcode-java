package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 13:43
 */
public class No143 {
    public ListNode reorderList(ListNode head) {
        if(head.next==null)return head;
        ListNode head1=head;
        ListNode mid=middleNode(head1);
        ListNode head2=mid.next;
        mid.next=null;
        head2=reverseList(head2);
        ListNode nxt,nxt2;
        while (head1!=null&&head2!=null){
            nxt=head1.next;
            nxt2=head2.next;
            head1.next=head2;
            head2.next=nxt;
            head1=nxt;
            head2=nxt2;
        }
        return head;

    }
    public ListNode middleNode(ListNode head) {

        ListNode low=head,fast=head;
        while (fast!=null&&fast.next!=null){
            low=low.next;
            fast=fast.next.next;
        }
        return low;

    }
    public ListNode reverseList(ListNode head) {
        ListNode pre,cur,nxt;
        pre=null;
        cur=head;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //
        //输入：head = [1,2,3,4]
        //输出：[1,4,2,3]
        //示例 2：
        //
        //
        //
        //输入：head = [1,2,3,4,5]
        //输出：[1,5,2,4,3]
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        No143 no143 = new No143();
        no143.reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
        head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        no143.reorderList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
