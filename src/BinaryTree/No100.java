package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-09 12:06
 */
public class No100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p,q);
    }
    public boolean isSame(TreeNode p,TreeNode q){
        if(p==null&&q==null)return true;
        else if (p==null||q==null) {
            return false;
        }else if(p.val==q.val){
            return isSame(p.left,q.left)&&isSame(p.right,q.right);

        }
        return false;

    }
    public static void main(String[] args) {
        //输入：p = [1,2,3], q = [1,2,3]
        //输出：true
        //示例 2：
        //
        //
        //输入：p = [1,2], q = [1,null,2]
        //输出：false
        //示例 3：
        //
        //
        //输入：p = [1,2,1], q = [1,1,2]
        //输出：false
        //

        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        No100 no100=new No100();
        System.out.println(no100.isSameTree(p, q));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);
        q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(1);
        System.out.println(no100.isSameTree(p, q));



    }
}
