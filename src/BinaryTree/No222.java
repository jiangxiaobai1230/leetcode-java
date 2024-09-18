package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-10 22:24
 */
public class No222 {
    private int count=0;
    public int countNodes(TreeNode root) {
        dfs(root);
        return count;


    }
    public void dfs(TreeNode node){
        if(node==null)return ;
        else{
            count++;
            dfs(node.left);
            dfs(node.right);

        }

    }

    public static void main(String[] args) {

        //输入：root = [1,2,3,4,5,6]
        //输出：6
        //示例 2：
        //
        //输入：root = []
        //输出：0
        //示例 3：
        //
        //输入：root = [1]
        //输出：1

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        System.out.println(new No222().countNodes(root));

        TreeNode root2 = null;
        System.out.println(new No222().countNodes(root2));

        TreeNode root3 = new TreeNode(1);
        System.out.println(new No222().countNodes(root3));


    }
}
