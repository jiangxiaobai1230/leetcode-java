package src.LinkNode;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-14 10:26
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}