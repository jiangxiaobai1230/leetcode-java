package src.BinaryTree;


/**
 * @author: Yuan Yuqing
 * @date: 2024-04-23 10:55
 */
public class No538 {
    private int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)return null;
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }
    public static void main(String[] args) {

        //输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
        //输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
        //示例 2：
        //
        //输入：root = [0,null,1]
        //输出：[1,null,1]
        //示例 3：
        //
        //输入：root = [1,0,2]
        //输出：[3,3,2]
        //示例 4：
        //
        //输入：root = [3,2,4,1]
        //输出：[7,9,4,10]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(8);
        No538 no538 = new No538();
        TreeNode treeNode = no538.convertBST(root);
        bfs bfs= new bfs();
        bfs.bfs(treeNode);
        System.out.println("=========");

        root= new TreeNode(0);
        root.right = new TreeNode(1);
        bfs.bfs(no538.convertBST(root));
        System.out.println("=========");
        root= new TreeNode(1);
        root.left = new TreeNode(0);
        bfs.bfs(no538.convertBST(root));
        System.out.println("=========");
        root= new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        bfs.bfs(no538.convertBST(root));


    }
}
