package src.BinaryTree;

import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-06 22:22
 */

//多叉树-n


//class Node1 {
//    public int val;
//    public Node1 left;
//    public Node1 right;
//    public Node1 next;
//
//    public Node1() {
//    }
//
//    public Node1(int _val) {
//        val = _val;
//    }
//
//    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
//        val = _val;
//        left = _left;
//        right = _right;
//        next = _next;
//    }
//}


public class Node1 {
    public int val;
    public List<Node1> children;


    public Node1(int val) {
        this.val = val;
    }

    public Node1() {
    }

    public Node1(int val, List<Node1> children) {
        this.val = val;
        this.children = children;
    }
}
