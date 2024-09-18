package src.BinaryTree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-07 17:55
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class No117 {
    public Node connect(Node root) {
        if(root==null) return root;
        Deque<Node> deque=new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int len=deque.size();
            Node pre=null;
            Node node=null;
            while (len>0){
                node=deque.pop();
                len--;
                if(pre==null)pre=node;
                else {
                    pre.next=node;
                    pre=node;
                }
                if(node.left!=null)deque.offer(node.left);
                if(node.right!=null)deque.offer(node.right);
            }
            node.next=null;
        }
        return root;

    }

    public static void main(String[] args) {
        //输入：root = [1,2,3,4,5,null,7]
        //输出：[1,#,2,3,#,4,5,7,#]
        //解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
        //示例 2：
        //
        //输入：root = []
        //输出：[]


        Node Node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node.left = node2;
        Node.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        No117 no117 = new No117();
        Node node = no117.connect(Node);
//        for (int i = 0; i < 7; i++) {
//            System.out.println(node.val);
//            node = node.next;
//        }


        Node n = no117.connect(new Node());
//        for (int i = 0; i < 7; i++) {
//            System.out.println(n.val);
//            n = n.next;
//        }
    }
}
