package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-22 22:07
 */
public class No450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        return delete(root,key);

    }
    public TreeNode delete(TreeNode root,int key){
        if(root==null)return root;
        if(root.val>key)root.left=delete(root.left,key);
        if(root.val<key)root.right=delete(root.right,key);
        if(root.val==key){
            if(root.left==null&&root.right==null)
                root=null;
            else if (root.left==null&&root.right!=null) {
                root=root.right;

            } else if (root.right==null&&root.left!=null) {
                root=root.left;
            }else {
                TreeNode l=root.left;
                while (l.right!=null)l=l.right;
                l.right=root.right;
                return root.left;
            }

        }
        return root;
    }
    public static void main(String[] args) {

        //输入：root = [5,3,6,2,4,null,7], key = 3
        //输出：[5,4,6,2,null,null,7]
        //解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
        //一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
        //另一个正确答案是 [5,2,6,null,4,null,7]。
        //
        //
        //示例 2:
        //
        //输入: root = [5,3,6,2,4,null,7], key = 0
        //输出: [5,3,6,2,4,null,7]
        //解释: 二叉树不包含值为 0 的节点
        //示例 3:
        //
        //输入: root = [], key = 0
        //输出: []

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        System.out.println(root);
        No450 no450 = new No450();
        TreeNode res = no450.deleteNode(root,3);

        bfs bfs= new bfs();
        bfs.bfs(res);

        res= no450.deleteNode(root,0);
        bfs.bfs(res);

        res= no450.deleteNode(null,5);
        bfs.bfs(res);



    }
}
