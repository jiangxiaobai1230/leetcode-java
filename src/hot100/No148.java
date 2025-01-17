package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-16 23:18
 */
public class No148 {

    //https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/?envType=study-plan-v2&envId=top-100-liked

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rightHead=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(rightHead);
        ListNode dummy=new ListNode(0),res=dummy;
        while (left!=null&&right!=null){
            if(left.val<=right.val){
                res.next=left;
                left=left.next;
                res=res.next;
            }else {
                res.next=right;
                right=right.next;
                res=res.next;
            }
        }
        if(left!=null)res.next=left;
        else res.next=right;
        return dummy.next;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：head = [4,2,1,3]
        //输出：[1,2,3,4]
        //示例 2：
        //
        //
        //输入：head = [-1,5,3,4,0]
        //输出：[-1,0,3,4,5]
        //示例 3：
        //
        //输入：head = []
        //输出：[]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        No148 no148 = new No148();
        head = no148.sortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("=======================================");
        head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);
        head = no148.sortList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("=======================================");
        head = no148.sortList(null);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
