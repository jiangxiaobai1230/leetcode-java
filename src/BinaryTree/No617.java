package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-17 10:53
 */
public class No617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) {
            return null;
        }
        return dfs(root1,root2);

    }
    public TreeNode dfs(TreeNode node1,TreeNode node2){
        if(node1==null&& node2==null) {
            return null;
        }
        if(node1==null) {
            return node2;
        }
        if(node2==null) {
            return node1;
        }
        TreeNode node=new TreeNode(node1.val+node2.val);
        node.left=dfs(node1.left,node2.left);
        node.right=dfs(node1.right,node2.right);
        return node;


    }

    public static void main(String[] args) {

        //输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
        //输出：[3,4,5,5,4,null,7]
        //示例 2：
        //
        //输入：root1 = [1], root2 = [1,2]
        //输出：[2,2]
        //

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        No617 no617 = new No617();
        TreeNode treeNode = no617.mergeTrees(root1, root2);
        bfs bfs = new bfs();
        bfs.bfs(treeNode);
        System.out.println();

        root1 = new TreeNode(1);
        root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        treeNode = no617.mergeTrees(root1, root2);
        bfs.bfs(treeNode);
        System.out.println();

        //root1 =
        //[1,2,null,3]
        //root2 =
        //[1,null,2,null,3]

        root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        treeNode = no617.mergeTrees(root1, root2);
        bfs.bfs(treeNode);
        System.out.println();




    }
}
