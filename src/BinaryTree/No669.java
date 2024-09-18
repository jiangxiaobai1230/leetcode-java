package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-23 10:03
 */
public class No669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)return null;
        if(root.val<low)return trimBST(root.right,low,high);
        if(root.val>high)return trimBST(root.left,low,high);
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;

    }

    public static void main(String[] args) {
        //输入：root = [1,0,2], low = 1, high = 2
        //输出：[1,null,2]
        //示例 2：
        //
        //
        //输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
        //输出：[3,2,null,1]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        int low = 1;
        int high = 2;
        No669 no669 = new No669();
        TreeNode treeNode = no669.trimBST(root, low, high);
        bfs  bfs= new bfs();
        bfs.bfs(treeNode);


        root= new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        low = 1;
        high = 3;
//        no669 = new No669();
        treeNode = no669.trimBST(root, low, high);
        bfs.bfs(treeNode);

    }
}
