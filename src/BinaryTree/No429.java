package src.BinaryTree;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-05 23:07
 */
public class No429 {
    public List<List<Integer>> levelOrder(Node1 root) {
        List<List<Integer>> res=new ArrayList<>();

        Deque<Node1> deque=new LinkedList<>();
        if(root==null)return res;
        deque.offer(root);
        while (!deque.isEmpty()){
            int len=deque.size();
            List<Integer> tmp=new ArrayList<>();
            while (len>0){
                Node1 node1 =deque.pop();
                len--;
                tmp.add(node1.val);
                if(node1.children!=null) {
                    for (int i = 0; i < node1.children.size(); i++) {
                        deque.offer(node1.children.get(i));
                    }
                }
            }
            res.add(tmp);



        }
        return res;


    }
    public static void main(String[] args) {

        //输入：root = [1,null,3,2,4,null,5,6]
        //输出：[[1],[3,2,4],[5,6]]
        //示例 2：
        //
        //
        //
        //输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
        //输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

        Node1 node1=new Node1(1);
        Node1 node2=new Node1(2);
        Node1 node3=new Node1(3);
        Node1 node4=new Node1(4);
        Node1 node5=new Node1(5);
        Node1 node6=new Node1(6);
        node1.children=new ArrayList<>();
        node1.children.add(node3);
        node1.children.add(node2);
        node1.children.add(node4);
        node3.children=new ArrayList<>();
        node3.children.add(node5);
        node3.children.add(node6);
        No429 no429=new No429();
        no429.levelOrder(node1);
        for (int i = 0; i < no429.levelOrder(node1).size(); i++) {
            System.out.println(no429.levelOrder(node1).get(i));
        }
        System.out.println("===========");

        Node1 node11=new Node1(1);
        Node1 node12=new Node1(2);
        Node1 node13=new Node1(3);
        Node1 node14=new Node1(4);
        Node1 node115 =new Node1(5);
        Node1 node116 =new Node1(6);
        Node1 node117 =new Node1(7);
        Node1 node118 =new Node1(8);
        Node1 node119 =new Node1(9);
        Node1 node1110 =new Node1(10);
        Node1 node1111 =new Node1(11);
        Node1 node1112 =new Node1(12);
        Node1 node1113 =new Node1(13);
        Node1 node1114 =new Node1(14);
        node11.children=new ArrayList<>();
        node11.children.add(node12);
        node11.children.add(node13);
        node11.children.add(node14);
        node11.children.add(node115);
        node12.children=new ArrayList<>();
        node12.children.add(node116);
        node12.children.add(node117);
        node12.children.add(node118);
        node12.children.add(node119);
        node13.children=new ArrayList<>();
        node13.children.add(node1110);
        node13.children.add(node1111);
        node13.children.add(node1112);
        node13.children.add(node1113);
        node13.children.add(node1114);
        no429.levelOrder(node11);
        for (int i = 0; i < no429.levelOrder(node11).size(); i++) {
            System.out.println(no429.levelOrder(node11).get(i));
        }


    }




}
