package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-14 23:55
 */
public class No25 {
    //https://leetcode.cn/problems/reverse-nodes-in-k-group/solutions/10416/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/?envType=study-plan-v2&envId=top-100-liked

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy,start=dummy,end=dummy;

        while (end.next!=null){
            for(int i=0;i<k;i++){
                end=end.next;
                if(end==null)break;
            }
            if(end==null)break;
            ListNode next=end.next;
            end.next=null;
            start=pre.next;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;

    }
    public ListNode reverse(ListNode begin){
        ListNode last=null,cur=begin;
        while (cur!=null){
            ListNode t=cur.next;
            cur.next=last;
            last=cur;
            cur=t;

        }
        return last;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：head = [1,2,3,4,5], k = 2
        //输出：[2,1,4,3,5]
        //示例 2：
        //
        //
        //
        //输入：head = [1,2,3,4,5], k = 3
        //输出：[3,2,1,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        No25 no25 = new No25();
        head = no25.reverseKGroup(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("=======================================");
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = no25.reverseKGroup(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("=======================================");

    }
}
