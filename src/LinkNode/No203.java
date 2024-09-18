package src.LinkNode;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-12 16:45
 */

class ListNodeNode {
    int val;
    ListNodeNode next;
    ListNodeNode(){}
    ListNodeNode(int val) {
        this.val = val;
    }
    ListNodeNode(int val, ListNodeNode next) {
        this.val = val;
        this.next = next;
    }

}
public class No203 {
    public ListNodeNode removeElements(ListNodeNode head, int val) {

        if(head == null){
            return null;
        }
        if(head.next == null){
            if(head.val == val){
                return null;
            }else{
                return head;

            }
        }
        while(head!=null&&head.val==val){
            head=head.next;

        }
        ListNodeNode currentNode = head;
        ListNodeNode preNode = head;
        while(currentNode != null){
            if(currentNode.val == val){
                preNode.next=currentNode.next;
                currentNode=currentNode.next;
            }else {
                preNode=currentNode;
                currentNode=currentNode.next;

            }
        }


        return head;


    }

    public static void main(String[] args) {

        //head = [1,2,6,3,4,5,6], val = 6构造ListNode
//        src.LinkNode.ListNode head = new src.LinkNode.ListNode(1);
//        head.next = new src.LinkNode.ListNode(2);
//        head.next.next = new src.LinkNode.ListNode(6);
//        head.next.next.next = new src.LinkNode.ListNode(3);
//        head.next.next.next.next = new src.LinkNode.ListNode(4);
//        head.next.next.next.next.next = new src.LinkNode.ListNode(5);
//        head.next.next.next.next.next.next = new src.LinkNode.ListNode(6);
////        System.out.println(head.next.next.next.next.next.next.next);

        ListNodeNode head = new ListNodeNode(1);
        head.next = new ListNodeNode(1);
        head.next.next = new ListNodeNode(1);
        head.next.next.next = new ListNodeNode(1);

//        System.out.println(head.next.next.next.next.next.next.next);

        No203 no203 = new No203();
        ListNodeNode l = new ListNodeNode(1);
        ListNodeNode listNode = no203.removeElements(null, 1);

        while(listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


    }





}
