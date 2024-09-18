package src.BinaryTree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-16 10:17
 */
public class No106 {
    private HashMap<Integer,Integer> hm=new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {


        for(int i=0;i< inorder.length;i++){
            hm.put(inorder[i],i);
        }
        post=postorder;
        return build(0,inorder.length-1,0,post.length-1);


    }
    public TreeNode build(int inStart,int inEnd,int postStart,int postEnd){
        if(inStart>inEnd || postStart>postEnd)return null;
        int root=post[postEnd];
        TreeNode node=new TreeNode(root);
        int inIndex=hm.get(root);
        node.left=build(inStart,inIndex-1,postStart,postStart+inIndex-inStart-1);
        node.right=build(inIndex+1,inEnd,postStart+inIndex-inStart,postEnd-1);

        return node;
    }
    public static void main(String[] args) {

        //输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        //输出：[3,9,20,null,null,15,7]
        //示例 2:
        //
        //输入：inorder = [-1], postorder = [-1]
        //输出：[-1]
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        No106 no106 = new No106();
        TreeNode treeNode = no106.buildTree(inorder, postorder);
        //输出整个树每个节点

        for (int i = 0; i < treeNode.getVal(); i++) {
            System.out.println(treeNode.getVal());
        }


        int[] inorder1 = {-1};
        int[] postorder1 = {-1};
        TreeNode treeNode1 = no106.buildTree(inorder1, postorder1);
        for (int i = 0; i < treeNode1.getVal(); i++) {
            System.out.println(treeNode1.getVal());
        }


    }
}
