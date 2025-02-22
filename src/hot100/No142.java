package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 13:32
 */
public class No142 {

    public ListNode detectCycle(ListNode head) {
        if(head==null)return null;
        ListNode low=head,fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(low==fast){
                low=head;
                while (low!=fast){
                    low=low.next;
                    fast=fast.next;
                }
                return low;
            }
        }
        return null;
    }
//    public ListNode detectCycle(ListNode head) {
//        if(hasCycle(head)){
//            ListNode dummy=new ListNode();
//            dummy.next=head;
//            ListNode low=dummy,fast=dummy;
//            while (fast==dummy||fast!=low){
//                fast=fast.next.next;
//                low=low.next;
//
//            }
//            low=dummy;
//            while (low!=fast){
//                low=low.next;
//                fast=fast.next;
//            }
//            return fast;
//        }else return null;
//
//    }
//    public boolean hasCycle(ListNode head) {
//        if(head==null)return false;
//        ListNode low=head,fast=head.next;
//        while (fast!=null&&fast.next!=null&&fast!=low){
//            fast=fast.next.next;
//            low=low.next;
//        }
//        if(fast==low)return true;
//        return false;
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //
        //输入：head = [3,2,0,-4], pos = 1
        //输出：返回索引为 1 的链表节点
        //解释：链表中有一个环，其尾部连接到第二个节点。
        //示例 2：
        //
        //
        //
        //输入：head = [1,2], pos = 0
        //输出：返回索引为 0 的链表节点
        //解释：链表中有一个环，其尾部连接到第一个节点。
        //示例 3：
        //
        //
        //
        //输入：head = [1], pos = -1
        //输出：返回 null
        //解释：链表中没有环。
        No142 no142 = new No142();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        ListNode res = no142.detectCycle(head);
        System.out.println(res.val);
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        res = no142.detectCycle(head);
        System.out.println(res.val);
        head = new ListNode(1);
        res = no142.detectCycle(head);
//        System.out.println(res.val);

    }
}
