//package src.BinaryTree;
//
//import java.util.Deque;
//import java.util.LinkedList;
//
///**
// * @author: Yuan Yuqing
// * @date: 2024-04-07 17:55
// */
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node next;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, Node _left, Node _right, Node _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next =  _next;
//    }
//}
//public class No116 {
//
//
//
//    public Node connect(Node root) {
//        if(root==null) return root;
//        Deque<Node> deque=new LinkedList<>();
//        deque.offer(root);
//        while (!deque.isEmpty()){
//            int len=deque.size();
//            Node pre=null;
//            Node node=null;
//            while (len>0){
//                node=deque.pop();
//                len--;
//                if(pre==null)pre=node;
//                else {
//                    pre.next=node;
//                    pre=node;
//                }
//                if(node.left!=null)deque.offer(node.left);
//                if(node.right!=null)deque.offer(node.right);
//            }
//            node.next=null;
//        }
//        return root;
//
//    }
//    public static void main(String[] args) {
//
//        //输入：root = [1,2,3,4,5,6,7]
//        //输出：[1,#,2,3,#,4,5,6,7,#]
//        //解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
//        //示例 2:
//        //
//        //输入：root = []
//        //输出：[]
//        //
//
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//
//        No116 no116 = new No116();
//        Node node=no116.connect(root);
//        //广序遍历
////        while (node!=null){
////            System.out.print(node.val+" ");
////            node=node.next;
////        }
//
//
//    }
//}
