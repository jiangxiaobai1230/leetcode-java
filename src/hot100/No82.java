package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 17:31
 */
public class No82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        while (cur.next!=null){
            int num = cur.next.val;
            ListNode repeatedNode=cur.next;
            while (repeatedNode!=null&&repeatedNode.next!=null&&repeatedNode.next.val==num){
                repeatedNode=repeatedNode.next;
            }
            if(repeatedNode!=cur.next) cur.next=repeatedNode.next;
            else cur=cur.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：head = [1,2,3,3,4,4,5]
        //输出：[1,2,5]
        //示例 2：
        //
        //
        //输入：head = [1,1,1,2,3]
        //输出：[2,3]
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,new ListNode(4,new ListNode(4,new ListNode(5)))))));
        No82 no82 = new No82();
        ListNode res = no82.deleteDuplicates(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
        head=new ListNode(1,new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3)))));
        res = no82.deleteDuplicates(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }

    }
}

