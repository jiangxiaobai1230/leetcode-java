package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 17:05
 */
public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode slow=dummy,fast=dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;

    }

    public static void main(String[] args) {
        //输入：head = [1,2,3,4,5], n = 2
        //输出：[1,2,3,5]
        //示例 2：
        //
        //输入：head = [1], n = 1
        //输出：[]
        //示例 3：
        //
        //输入：head = [1,2], n = 1
        //输出：[1]
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        No19 no19 = new No19();
        ListNode res = no19.removeNthFromEnd(head,2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
        head=new ListNode(1);
        res = no19.removeNthFromEnd(head,1);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
        head=new ListNode(1,new ListNode(2));
        res = no19.removeNthFromEnd(head,1);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
