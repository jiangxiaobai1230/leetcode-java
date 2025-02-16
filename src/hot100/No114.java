package src.hot100;

import src.BinaryTree.TreeNode;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-19 23:44
 */
public class No114 {
    public void flatten(TreeNode root) {
        if(root==null)return;
        while (root!=null){
            if(root.left==null){
                root=root.right;
            }else {
                TreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }

        }

    }

    public static void main(String[] args) {
        //输入：root = [1,2,5,3,4,null,6]
        //输出：[1,null,2,null,3,null,4,null,5,null,6]
        //示例 2：
        //
        //输入：root = []
        //输出：[]
        //示例 3：
        //
        //输入：root = [0]
        //输出：[0]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new No114().flatten(root);

        while (root != null) {
            System.out.println(root.getVal());
            root = root.right;
        }
        System.out.println();



    }
}
