package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-22 18:03
 */
public class No100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)return true;
        if(p==null||q==null)return false;
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
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
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode q = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        No100 no100 = new No100();
        System.out.println(no100.isSameTree(p,q));
        p = new TreeNode(1,new TreeNode(2),null);
        q = new TreeNode(1,null,new TreeNode(2));
        System.out.println(no100.isSameTree(p,q));
        p = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        q = new TreeNode(1,new TreeNode(1),new TreeNode(2));
        System.out.println(no100.isSameTree(p,q));

    }
}
