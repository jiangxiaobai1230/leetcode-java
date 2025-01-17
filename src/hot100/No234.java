package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-12 22:33
 */
public class No234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)return true;
        ListNode slow=head,fast=head,cur=head,pre=null;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            cur.next=pre;
            pre=cur;
            cur=slow;



        }
        if(fast==null){
            while (pre!=null&&cur!=null) {
                if (pre.val != cur.val) return false;
                pre=pre.next;
                cur=cur.next;
            }
        }else {
            cur=cur.next;
            while (pre!=null&&cur!=null) {
                if (pre.val != cur.val) return false;
                pre=pre.next;
                cur=cur.next;
            }

        }


        return true;
    }


    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：head = [1,2,2,1]
        //输出：true
        //示例 2：
        //
        //
        //输入：head = [1,2]
        //输出：false
        No234 no234 = new No234();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(no234.isPalindrome(head));
        head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(no234.isPalindrome(head));
    }
}
