package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-09 11:06
 */
public class No226 {
    public TreeNode invertTree(TreeNode root) {

        getInversedTree(root);

        return root;
    }
    public void getInversedTree(TreeNode node){
        if(node==null)return;
        else{
            TreeNode t=node.left;
            node.left=node.right;
            node.right=t;
            getInversedTree(node.left);
            getInversedTree(node.right);
        }

    }

    public static void main(String[] args) {

        //输入：root = [4,2,7,1,3,6,9]
        //输出：[4,7,2,9,6,3,1]
        //示例 2：
        //
        //
        //
        //输入：root = [2,1,3]
        //输出：[2,3,1]
        //示例 3：
        //
        //输入：root = []
        //输出：[]


        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode res = new No226().invertTree(root);
        System.out.println(res.val);

        root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(3);
        res = new No226().invertTree(root);
        System.out.println(res.val);

    }
}
