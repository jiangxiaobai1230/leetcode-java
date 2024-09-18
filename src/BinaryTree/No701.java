package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-22 21:45
 */
public class No701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root,val);

    }

    public TreeNode insert(TreeNode root,int val){
        if(root==null)return new TreeNode(val);
        if(root.val>val)root.left=insert(root.left,val);
        if(root.val<val)root.right= insert(root.right,val);
        return root;


    }
//    public TreeNode insert(TreeNode root,int val){
//        if(root.val>val&&root.left==null){
//            TreeNode node=new TreeNode(val);
//            root.left=node;
//            return root;
//        }
//        if(root.val<val&&root.right==null){
//            TreeNode node=new TreeNode(val);
//            root.right=node;
//            return root;
//        }
//        if(root.val>val)return insert(root.left,val);
//        if(root.val<val)return insert(root.right,val);
//        return root;
//
//
//    }

    public static void main(String[] args) {

        //输入：root = [4,2,7,1,3], val = 5
        //输出：[4,2,7,1,3,5]
        //解释：另一个满足题目要求可以通过的树是：
        //
        //示例 2：
        //
        //输入：root = [40,20,60,10,30,50,70], val = 25
        //输出：[40,20,60,10,30,50,70,null,null,25]
        //示例 3：
        //
        //输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
        //输出：[4,2,7,1,3,5]

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 5;
        System.out.println(root);
        No701 no701 = new No701();
        TreeNode treeNode = no701.insertIntoBST(root, val);
        bfs b= new bfs();
        b.bfs(treeNode);

        root= new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);
        val = 25;
        treeNode= no701.insertIntoBST(root, val);
        b.bfs(treeNode);

        root= new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = null;
        val = 5;

        treeNode= no701.insertIntoBST(root, val);
        b.bfs(treeNode);







    }
}
