package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 13:21
 */
public class No876 {
    public ListNode middleNode(ListNode head) {

        ListNode low=head,fast=head;
        while (fast!=null&&fast.next!=null){
            low=low.next;
            fast=fast.next.next;
        }
        return low;

    }

    public static void main(String[] args) {
        //输入：head = [1,2,3,4,5]
        //输出：[3,4,5]
        //解释：链表只有一个中间结点，值为 3 。
        //示例 2：
        //
        //
        //输入：head = [1,2,3,4,5,6]
        //输出：[4,5,6]
        //解释：该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
        //
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        No876 no876 = new No876();
        ListNode res = no876.middleNode(head);
        System.out.println(res.val);
//        while (res!=null){
//            System.out.println(res.val);
//            res=res.next;
//        }
        head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6))))));
        res = no876.middleNode(head);
//        while (res!=null){
//            System.out.println(res.val);
//            res=res.next;
//        }
        System.out.println(res.val);
    }
}
