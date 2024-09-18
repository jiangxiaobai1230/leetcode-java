package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-18 10:04
 */
public class No700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        else {
            TreeNode node = searchBST(root.left, val);
            if (node != null) return node;
            node = searchBST(root.right, val);
            return node;


        }


    }

    public static void main(String[] args) {
        //输入：root = [4,2,7,1,3], val = 2
        //输出：[2,1,3]
        //示例 2:
        //
        //
        //输入：root = [4,2,7,1,3], val = 5
        //输出：[]

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        No700 no700 = new No700();
        TreeNode treeNode = no700.searchBST(root, 2);
        bfs bfs = new bfs();
        bfs.bfs(treeNode);


        treeNode = no700.searchBST(root, 5);
        bfs.bfs(treeNode);


    }
}
