package src.LinkNode;

import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-16 22:06
 */
public class IntersectedLinkNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA==null||headB==null){
            return null;
        }else{
            ListNode curA=headA;
            ListNode curB=headB;
            int lenA=0,lenB=0;
            while (curA!=null){
                lenA++;
                curA=curA.next;
            }
            while (curB!=null){
                lenB++;
                curB=curB.next;
            }

            curA=headA;
            curB=headB;
            if(lenA>=lenB){
                for(int i=0;i<lenA-lenB;i++){
                    curA=curA.next;
                }
                while(curB!=null&&curA!=null&&curA!=curB){
                    curA=curA.next;
                    curB=curB.next;

                }
                return curA;
            } else {
                for(int i=0;i<lenB-lenA;i++){
                    curB=curB.next;
                }
                while(curB!=null&&curA!=null&&curA!=curB){
                    curA=curA.next;
                    curB=curB.next;

                }
                return curB;

            }


        }


    }

    public static void main(String[] args) {

        //输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
        //输出：Intersected at '8'
        //解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
        //从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
        //在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
//        ListNode node4=new ListNode(4);
//        ListNode node1=new ListNode(1);
//        ListNode node8=new ListNode(8);
//        ListNode node5=new ListNode(5);
//        ListNode node0=new ListNode(0);
//        ListNode listA=node4;
//        listA.next=node1;
//        listA.next.next=node8;
//        listA.next.next.next=node4;
//        listA.next.next.next.next=node5;
//        listA.next.next.next.next.next=null;
//        ListNode listB=node5;
//        listB.next=node0;
//        listB.next.next=new ListNode(1);
//        listB.next.next.next=node8;
//        listB.next.next.next.next=node4;
//        listB.next.next.next.next.next=node5;
//        listB.next.next.next.next.next.next=null;
//        System.out.println(new IntersectedLinkNode().getIntersectionNode(listA, listB).val);





    }
}
