package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-21 19:07
 */
public class No92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)return head;
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode p0=dummy,cur=dummy;
        for(int i=0;i<left-1;i++){
            p0=p0.next;
        }
        cur=p0.next;
        ListNode pre=null,nxt=null;
        for(int i=0;i<right-left+1;i++){
            nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        p0.next.next=cur;
        p0.next=pre;
        return dummy.next;
    }

    //自己写的有点粗糙

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if(left==right)return head;
//        int count=0;
//        ListNode cur=head;
//        ListNode p = null,nxt = head;
//        while (cur!=null&&count<=left){
//            count++;
//            if(count==left-1){
//                p=cur;
//                nxt=p.next;
//                p.next=null;
//                break;
//            }
//            cur=cur.next;
//        }
//        count=right-left;
//        ListNode pre=null,ccur=nxt;
//        while (count>=0){
//            ListNode nnxt=ccur.next;
//            ccur.next=pre;
//            pre=ccur;
//            ccur=nnxt;
//            count--;
//        }
//        if(p!=null) {
//            p.next = pre;
//            nxt.next = ccur;
//            return head;
//        }else {
//            nxt.next = ccur;
//            return pre;
//        }
//
//
//
//    }
//    public ListNode reverse(ListNode head){
//        ListNode pre=null,cur=head;
//        while (cur!=null){
//            ListNode nxt=cur.next;
//            cur.next=pre;
//            pre=cur;
//            cur=nxt;
//        }
//        return pre;
//    }

    public static void main(String[] args) {
        //输入：head = [1,2,3,4,5], left = 2, right = 4
        //输出：[1,4,3,2,5]
        //示例 2：
        //
        //输入：head = [5], left = 1, right = 1
        //输出：[5]
        //

        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        No92 no92 = new No92();
        ListNode res = no92.reverseBetween(head, 3, 4);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
        head=new ListNode(3,new ListNode(5));
        res = no92.reverseBetween(head, 1, 2);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
