package src;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-27 15:49
 */
import java.util.Arrays;

// 二叉树节点定义
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class FullBSTLCA {

    /**
     * 基于有序数组构造满二叉搜索树（保证满二叉树结构）
     * 思路：取数组中间元素为根，左半部分构造左子树，右半部分构造右子树
     */
    public static TreeNode buildFullBST(int[] sortedArray) {
        if (sortedArray == null || sortedArray.length == 0) {
            return null;
        }
        return build(sortedArray, 0, sortedArray.length - 1);
    }

    private static TreeNode build(int[] arr, int left, int right) {
        if (left > right) {
            return null;
        }
        // 取中间位置作为根（保证满二叉树结构）
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        // 递归构造左、右子树（满二叉树要求非叶子节点必有两个子节点）
        node.left = build(arr, left, mid - 1);
        node.right = build(arr, mid + 1, right);
        return node;
    }

    /**
     * 查找三个节点的最近公共祖先（LCA）
     */
    public static TreeNode findLCAOfThree(TreeNode root, TreeNode a, TreeNode b, TreeNode c) {
        if (root == null || a == null || b == null || c == null) {
            return null;
        }

        // 计算三个节点值的 min、mid、max
        int va = a.val;
        int vb = b.val;
        int vc = c.val;
        int minV = Math.min(Math.min(va, vb), vc);
        int maxV = Math.max(Math.max(va, vb), vc);
        // 计算中间值（简化：无需严格中间值，只需知道范围）

        // 从根节点开始查找LCA
        TreeNode current = root;
        while (current != null) {
            if (current.val > maxV) {
                // 当前节点值大于最大值，LCA在左子树
                current = current.left;
            } else if (current.val < minV) {
                // 当前节点值小于最小值，LCA在右子树
                current = current.right;
            } else {
                // 当前节点值在 [minV, maxV] 范围内，即为LCA
                return current;
            }
        }
        return null; // 理论上不会走到这里（三个节点都在树中）
    }

    /**
     * 辅助方法：根据值在BST中查找节点
     */
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (val < root.val) {
            return findNode(root.left, val);
        } else {
            return findNode(root.right, val);
        }
    }

    public static void main(String[] args) {
        // 构造满二叉搜索树（基于有序数组）
        // 示例树结构（满二叉树）：
        //       4
        //     /   \
        //    2     6
        //   / \   / \
        //  1   3 5   7
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = buildFullBST(sortedArray);

        // 测试案例1：三个节点分别为1、3、5
        TreeNode a = findNode(root, 1);
        TreeNode b = findNode(root, 3);
        TreeNode c = findNode(root, 5);
        TreeNode lca1 = findLCAOfThree(root, a, b, c);
        System.out.println("1、3、5的LCA：" + lca1.val); // 预期：4

        // 测试案例2：三个节点分别为2、3、6
        TreeNode d = findNode(root, 2);
        TreeNode e = findNode(root, 3);
        TreeNode f = findNode(root, 6);
        TreeNode lca2 = findLCAOfThree(root, d, e, f);
        System.out.println("2、3、6的LCA：" + lca2.val); // 预期：4

        // 测试案例3：三个节点在同一条左子树（1、2、3）
        TreeNode g = findNode(root, 1);
        TreeNode h = findNode(root, 2);
        TreeNode i = findNode(root, 3);
        TreeNode lca3 = findLCAOfThree(root, g, h, i);
        System.out.println("1、2、3的LCA：" + lca3.val); // 预期：2
    }
}
