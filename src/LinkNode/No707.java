package src.LinkNode;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-14 09:01
 */

class MyLinkedList {
    int size;
    ListNodeNode head;

    public MyLinkedList(){
        size=0;
        head=new ListNodeNode(0);

    }

    public int get(int index) {
        if(index<0 ||index>=size){
            return -1;
        }
        ListNodeNode cur=head;
        while(cur!=null&&index-->0){
            cur=cur.next;

        }
        return cur.next.val;

    }

    public void addAtHead(int val) {
        addAtIndex(0,val);

    }

    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        if(index==0){
            ListNodeNode newHead=new ListNodeNode(val);
            newHead.next=head.next;
            head.next=newHead;
            size++;
            return;
        }
        ListNodeNode cur=head;
        while(index-- >0){
            cur=cur.next;

        }
        ListNodeNode t=new ListNodeNode(val);
        size++;
        t.next=cur.next;
        cur.next=t;


    }

    public void deleteAtIndex(int index) {
        if(index<0||index>=size){
            return;

        }
        if(index==0){
            head=head.next;
            size--;
            return;
        }
        ListNodeNode cur=head;
        while(index-->0){
            cur=cur.next;

        }
        cur.next=cur.next.next;
        size--;


    }
}
public class No707 {


    public static void main(String[] args) {


        //给出测试代码["src.LinkNode.MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
        //[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]



        //["src.LinkNode.MyLinkedList","addAtHead","get","addAtHead","addAtHead","deleteAtIndex","addAtHead","get","get","get","addAtHead","deleteAtIndex"]
        //[[],[4],[1],[1],[5],[3],[7],[3],[3],[3],[1],[4]]


        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
        System.out.println(myLinkedList.get(1));

        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);




//
//        src.LinkNode.MyLinkedList myLinkedList = new src.LinkNode.MyLinkedList();
//        myLinkedList.addAtHead(2);
//        myLinkedList.deleteAtIndex(1);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(3);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(5);
//        myLinkedList.addAtTail(5);
//        System.out.println(myLinkedList.get(5));
//        myLinkedList.deleteAtIndex(6);
//        myLinkedList.deleteAtIndex(4);









//
//        src.LinkNode.MyLinkedList myLinkedList = new src.LinkNode.MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//        System.out.println(myLinkedList.get(1));              // 返回 2
//        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//        System.out.println(myLinkedList.get(1));             // 返回 3

//        for (int i = 0; i < myLinkedList.size; i++) {
//            System.out.println(myLinkedList.get(i));
//        }
    }


/**
 * Your src.LinkNode.MyLinkedList object will be instantiated and called as such:
 * src.LinkNode.MyLinkedList obj = new src.LinkNode.MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
