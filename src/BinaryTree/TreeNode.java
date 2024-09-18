package src.BinaryTree;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-01 22:37
 */
public class TreeNode {

    int val;
    public TreeNode left;
    public TreeNode right;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
