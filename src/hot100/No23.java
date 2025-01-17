package src.hot100;

import src.LinkNode.ListNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-17 23:48
 */
public class No23 {

    //https://leetcode.cn/problems/merge-k-sorted-lists/solutions/2384517/javapython3cfen-zhi-fa-you-xian-dui-lie-b60ou/?envType=study-plan-v2&envId=top-100-liked
    public ListNode mergeKLists(ListNode[] lists) {
        return divided(lists,0, lists.length);

    }
    ListNode divided(ListNode[] lists,int l,int r){
        if(l>=r)return null;
        if(l==r-1)return lists[l];
        int mid=l+((r-l)>>1);
        return merge(divided(lists,l,mid),divided(lists,mid,r));

    }
    ListNode merge(ListNode list1,ListNode list2){
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode dummy=new ListNode(0),res=dummy;
        while (list1!=null&&list2!=null){
            if(list1.val<= list2.val){
                res.next=list1;
                list1=list1.next;
            }else {
                res.next=list2;
                list2=list2.next;
            }
            res=res.next;
        }
        if(list1==null)res.next=list2;
        else res.next=list1;
        return dummy.next;
    }
    public static void main(String[] args) {
        //示例 1：
        //
        //输入：lists = [[1,4,5],[1,3,4],[2,6]]
        //输出：[1,1,2,3,4,4,5,6]
        //解释：链表数组如下：
        //[
        //  1->4->5,
        //  1->3->4,
        //  2->6
        //]
        //将它们合并到一个有序链表中得到。
        //1->1->2->3->4->4->5->6
        //示例 2：
        //
        //输入：lists = []
        //输出：[]
        //示例 3：
        //
        //输入：lists = [[]]
        //输出：[]
        //

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        ListNode[] lists = new ListNode[3];
        lists[0] = listNode1;
        lists[1] = listNode2;
        lists[2] = listNode3;
        No23 no23 = new No23();
        ListNode listNode = no23.mergeKLists(lists);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }


        System.out.println("==========================");
        listNode = no23.mergeKLists(new ListNode[]{});
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("==========================");
    }
}
