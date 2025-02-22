package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 16:58
 */
public class No237 {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：head = [4,5,1,9], node = 5
        //输出：[4,1,9]
        //解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
        //示例 2：
        //
        //
        //输入：head = [4,5,1,9], node = 1
        //输出：[4,5,9]
        //解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9

        ListNode head = new ListNode(4,new ListNode(5,new ListNode(1,new ListNode(9))));
        No237 no237 = new No237();
        no237.deleteNode(head.next);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
        head = new ListNode(4,new ListNode(5,new ListNode(1,new ListNode(9))));
        no237.deleteNode(head.next.next);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }

    }
}
