package src.BinaryTree;

import java.util.HashMap;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-16 10:46
 */
public class No105 {
    private HashMap<Integer,Integer> hm=new HashMap<>();
    private int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }
        pre=preorder;
        return build(0,pre.length-1,0,inorder.length-1);

    }
    public TreeNode  build(int preStart,int preEnd,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd)return null;
        int root=pre[preStart];
        TreeNode node=new TreeNode(root);
        int inIndex=hm.get(root);

        //
        node.left=build(preStart+1,preStart+inIndex-inStart,inStart,inIndex-1);
        node.right=build(preStart+inIndex-inStart+1,preEnd,inIndex+1,inEnd);
        return node;


    }
    public static void main(String[] args) {

        //输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //输出: [3,9,20,null,null,15,7]
        //示例 2:
        //
        //输入: preorder = [-1], inorder = [-1]
        //输出: [-1]


        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        No105 no105 = new No105();
        no105.buildTree(preorder,inorder);

        preorder = new int[]{-1};
        inorder = new int[]{-1};
        no105.buildTree(preorder,inorder);



    }
}
