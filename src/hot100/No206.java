package src.hot100;

import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-21 14:49
 */
public class No206 {
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
        //输入：head = [1,2,3,4,5]
        //输出：[5,4,3,2,1]
        //示例 2：
        //
        //
        //输入：head = [1,2]
        //输出：[2,1]
        //示例 3：
        //
        //输入：head = []
        //输出：[]
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        No206 no206 = new No206();
        ListNode res = no206.reverseList(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }

        head=new ListNode(1,new ListNode(2));
        res = no206.reverseList(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
        head=null;
        res = no206.reverseList(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
