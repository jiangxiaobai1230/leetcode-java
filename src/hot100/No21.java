package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-13 22:22
 */
public class No21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null&&list2==null)return null;
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode node=new ListNode(0),cur=node;
        while (list1 != null && list2 != null) {
            if(list1.val<=list2.val){
                cur.next=list1;
                list1=list1.next;
                cur=cur.next;
            }else {
                cur.next=list2;
                list2=list2.next;
                cur=cur.next;
            }

        }
        if(list1!=null){
            cur.next=list1;
        }
        if(list2!=null){
            cur.next=list2;
        }

        return node.next;


    }

    public static void main(String[] args) {
        //输入：l1 = [1,2,4], l2 = [1,3,4]
        //输出：[1,1,2,3,4,4]
        //示例 2：
        //
        //输入：l1 = [], l2 = []
        //输出：[]
        //示例 3：
        //
        //输入：l1 = [], l2 = [0]
        //输出：[0]
        No21 no21 = new No21();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode listNode = no21.mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("==========================");
        listNode = no21.mergeTwoLists(null, null);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("==========================");
        listNode = no21.mergeTwoLists(null, new ListNode(0));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
