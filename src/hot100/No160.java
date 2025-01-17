package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-11 23:29
 */
public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode curA=headA,curB=headB;
        while (curA!=null){
            lenA++;
            curA=curA.next;
        }
        while (curB!=null){
            lenB++;
            curB=curB.next;
        }
        if(lenA>lenB){
            int cnt=lenA-lenB;
            while (cnt>0){
                headA=headA.next;
                cnt--;
            }
        }else {
            int cnt=lenB-lenA;
            while (cnt>0){
                headB=headB.next;
                cnt--;
            }
        }
        while (headB!=null&&headA!=null){
            if(headA==headB)return headA;
            else {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
        //输出：Intersected at '8'
        //示例 2：

        //输入：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
        //输出：Intersected at '2'
        //示例 3：

        //输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
        //输出：No intersection


        No160 no160 = new No160();
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        ListNode headB = new ListNode(5);
        ListNode node5 = new ListNode(6);



        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        headB.next = node5;
        node5.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        no160.getIntersectionNode(headA,headB);
        while (headA != null) {
            System.out.println(headA.val);
            headA = headA.next;
        }
        while (headB != null) {
            System.out.println(headB.val);
            headB = headB.next;
        }
        System.out.println();




    }
}
