package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-12 23:32
 */
public class No141 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)return false;
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return true;
        }
        return false;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //
        //输入：head = [3,2,0,-4], pos = 1
        //输出：true
        //解释：链表中有一个环，其尾部连接到第二个节点。
        //示例 2：
        //
        //
        //
        //输入：head = [1,2], pos = 0
        //输出：true
        //解释：链表中有一个环，其尾部连接到第一个节点。
        //示例 3：
        //
        //
        //
        //输入：head = [1], pos = -1
        //输出：false
        //解释：链表中没有环。
        No141 no141 = new No141();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(no141.hasCycle(head));
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(no141.hasCycle(head));
        head = new ListNode(1);
        System.out.println(no141.hasCycle(head));
    }

}
