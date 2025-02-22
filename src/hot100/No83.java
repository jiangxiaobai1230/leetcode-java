package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 17:16
 */
public class No83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        while (cur!=null){
            int num=cur.val;
            while (cur.next!=null&&cur.next.val==num){
                cur.next=cur.next.next;
            }
            cur=cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：head = [1,1,2]
        //输出：[1,2]
        //示例 2：
        //
        //
        //输入：head = [1,1,2,3,3]
        //输出：[1,2,3]
        ListNode head = new ListNode(1,new ListNode(1,new ListNode(2)));
        No83 no83 = new No83();
        ListNode res = no83.deleteDuplicates(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
        head=new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3)))));
        res = no83.deleteDuplicates(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }

}
